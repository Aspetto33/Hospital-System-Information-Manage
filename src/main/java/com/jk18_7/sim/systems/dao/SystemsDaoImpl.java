package com.jk18_7.sim.systems.dao;

import com.jk18_7.sim.login.tools.JdbcTemplateUtils;
import com.jk18_7.sim.systems.entity.Systems;
import com.jk18_7.sim.systems.interfaces.SystemsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("systemsDao")
public class SystemsDaoImpl implements SystemsDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Systems> getSystems() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Systems ");
        List<Systems> list = query.list();
        if(list == null || list.size()<=0)
            return null;
        return list;
    }

    @Override
    public void addSystems(Systems systems) {
        JdbcTemplateUtils jdbcTemplateUtils = new JdbcTemplateUtils();
        JdbcTemplate jdbcTemplate = jdbcTemplateUtils.getJdbcTemplate();
        String sql = "insert into systems(s_name,s_version) values(?,?)";
        String[] info = {systems.getsName(),systems.getsVersion()};
        int update = jdbcTemplate.update(sql,info);
        System.out.println(update);
    }

    @Override
    public void updateSystems(Systems systems) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(systems);
        transaction.commit();
    }
}
