package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.entity.RolePermission;
import com.jk18_7.sim.authority.interfaces.PermissionDao;
import com.jk18_7.sim.authority.interfaces.RoleDao;
import com.jk18_7.sim.authority.interfaces.RolePermissionDao;
import com.jk18_7.sim.login.interfaces.LoginDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("permissionDao")
public class PermissionDaoImpl implements PermissionDao {
    @Resource
    private LoginDao loginDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RolePermissionDao rolePermissionDao;
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    @Override
    public Set<String> listPermissions(String uname) {
        Set<String> result = new HashSet<>();
        List<Role> roleList = roleDao.listRoles(uname);
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (Role role:roleList){
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from RolePermission where rId=:rid");
            query.setParameter("rid",role.getrId());
            List<RolePermission> list = query.list();
            rolePermissionList.addAll(list);
        }
        for (RolePermission rolePermission:rolePermissionList){
            Session session = sessionFactory.getCurrentSession();
            Permission permission = session.get(Permission.class,rolePermission.getpId());
            result.add(permission.getpName());
        }
        return result;
    }

    @Override
    public void add(Permission permission) {
       Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(permission);
        transaction.commit();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Permission permission = session.get(Permission.class,id);
        session.delete(permission);
        transaction.commit();
    }

    @Override
    public Permission getPermission(long id) {
        Session session = sessionFactory.getCurrentSession();
        Permission permission = session.get(Permission.class,id);
        return permission;
    }

    @Override
    public void update(Permission permission) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(permission);
        transaction.commit();
    }

    @Override
    public List<Permission> list(Role role) {
        List<Permission> result = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from RolePermission where rId=:rid");
        query.setParameter("rid",role.getrId());
        List<RolePermission> list = query.list();
        for (RolePermission rolePermission:list){
            Permission permission = session.get(Permission.class, rolePermission.getpId());
            result.add(permission);
        }
        return result;
    }

    @Override
    public Boolean needInterceptor(String requestURI) {
        List<Permission> list =list();
        for (Permission permission:list){
            if(permission.getDesc().equals(requestURI)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> listPermissionURLs(String uname) {
        Set<String> result = new HashSet<>();
        List<Role> list = roleDao.listRoles(uname);
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (Role role:list){
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from RolePermission where rId=:rid");
            query.setParameter("rid",role.getrId());
            List<RolePermission> list1 = query.list();
            rolePermissionList.addAll(list1);
        }
        for (RolePermission rolePermission:rolePermissionList){
            Session session = sessionFactory.getCurrentSession();
            Permission permission = session.get(Permission.class, rolePermission.getpId());
            result.add(permission.getDesc());
        }
        return result;
    }

    @Override
    public List<Permission> list() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Permission ");
        List<Permission> list = query.list();
        return list;
    }
}
