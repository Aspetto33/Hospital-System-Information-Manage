package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.UserRole;
import com.jk18_7.sim.authority.interfaces.UserRoleDao;
import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.tools.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Override
    public void setRoles(Users users, long[] rIds) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from UserRole where uId=:uid");
        query.setParameter("uid",users.getuId());
        List<UserRole> list = query.list();
        for(UserRole userRole:list){
            session.delete(userRole);
        }
        if(rIds!=null){
            for(long rid:rIds){
                UserRole userRole = new UserRole();
                userRole.setrId(rid);
                userRole.setuId(users.getuId());
                session.save(userRole);
            }
        }
        transaction.commit();
    }

    @Override
    public void deleteByUser(long uid) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from UserRole where uId =:uid");
        query.setParameter("uid",uid);
        List<UserRole> list = query.list();
        for (UserRole userRole:list){
            session.delete(userRole);
        }
        transaction.commit();
    }

    @Override
    public void deleteByRole(long rid) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from UserRole where rId=:rid");
        query.setParameter("rid",rid);
        List<UserRole> list = query.list();
        for (UserRole userRole:list){
            session.delete(userRole);
        }
        transaction.commit();
    }
}
