package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.entity.RolePermission;
import com.jk18_7.sim.authority.interfaces.RolePermissionDao;
import com.jk18_7.sim.login.tools.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("rolePermissionDao")
public class RolePermissionDaoImpl implements RolePermissionDao {
    @Override
    public void setPermissions(Role role, int[] pids) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from RolePermission where rId=:rid");
        query.setParameter("rid",role.getrId());
        List<RolePermission> list = query.list();
        for (RolePermission rolePermission:list){
            session.delete(rolePermission);
        }
        if(pids !=null){
           for (int pid:pids){
               RolePermission rolePermission = new RolePermission();
               rolePermission.setpId(pid);
               rolePermission.setrId(role.getrId());
               session.save(rolePermission);
           }
        }
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public void deleteByRole(int rid) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from RolePermission where rId=:rid");
        query.setParameter("rid",rid);
        List<RolePermission> list = query.list();
        for (RolePermission rolePermission:list){
            session.delete(rolePermission);
        }
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public void deleteByPermission(int pid) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from RolePermission where pId=:pid");
        query.setParameter("pid",pid);
        List<RolePermission> list = query.list();
        for (RolePermission rolePermission:list){
            session.delete(rolePermission);
        }
        transaction.commit();
        hibernateUtils.closeSession();
    }
}
