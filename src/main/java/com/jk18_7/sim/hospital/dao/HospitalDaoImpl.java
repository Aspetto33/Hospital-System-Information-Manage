package com.jk18_7.sim.hospital.dao;

import com.jk18_7.sim.hospital.entity.Hospital;
import com.jk18_7.sim.hospital.interfaces.HospitalDao;
import com.jk18_7.sim.login.tools.HibernateUtils;
import com.jk18_7.sim.login.tools.JdbcTemplateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("hospitalDao")
@Transactional
public class HospitalDaoImpl implements HospitalDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private HibernateUtils hibernateUtils=null;
    @Override
    public List<Hospital> getHospital() {
        hibernateUtils = new HibernateUtils();
        List<Hospital> hospitalList = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Hospital ");
            List<Hospital> list = query.list();
            if(list == null || list.size()<=0)
                return null;
            else {
                for(Hospital hospitals:list){
                    hospitalList.add(hospitals);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hospitalList;
    }

    @Override
    public void addHospital(Hospital hospital) {
        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
        String sql = "insert into hospital(de_count,h_area,d_count,h_time) values(?,?,?,?)";
        String [] info = {hospital.getDeCount(),hospital.gethArea(),hospital.getdCount(),hospital.gethTime()};
        int update = jdbcTemplate.update(sql,info);

        System.out.println(update);
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(hospital);
//        transaction.commit();
    }

    @Override
    public void deleteHospital(int hId) {
        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
        String sql = "delete from hospital where h_id=?";
        jdbcTemplate.update(sql,hId);
    }

}
