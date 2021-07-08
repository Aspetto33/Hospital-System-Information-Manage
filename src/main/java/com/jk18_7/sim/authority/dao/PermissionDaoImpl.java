package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.entity.RolePermission;
import com.jk18_7.sim.authority.interfaces.PermissionDao;
import com.jk18_7.sim.authority.interfaces.RoleDao;
import com.jk18_7.sim.authority.interfaces.RolePermissionDao;
import com.jk18_7.sim.login.interfaces.LoginDao;
import com.jk18_7.sim.login.tools.HibernateUtils;
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
    @Override
    public Set<String> listPermissions(String uname) {
        Set<String> result = new HashSet<>();
        List<Role> roleList = roleDao.listRoles(uname);
        List<RolePermission> rolePermissionList = new ArrayList<>();
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        for (Role role:roleList){
            Query query = session.createQuery("from RolePermission where rId=:rid");
            query.setParameter("rid",role.getrId());
            List<RolePermission> list = query.list();
            rolePermissionList.addAll(list);
        }
        for (RolePermission rolePermission:rolePermissionList){
            Permission permission = session.get(Permission.class,rolePermission.getpId());
            result.add(permission.getpName());
        }
        hibernateUtils.closeSession();
        return result;
    }

    @Override
    public void add(Permission permission) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(permission);
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public void delete(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Permission permission = session.get(Permission.class,id);
        session.delete(permission);
        rolePermissionDao.deleteByPermission(id);
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public Permission getPermission(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Permission permission = session.get(Permission.class,id);
        hibernateUtils.closeSession();
        return permission;
    }

    @Override
    public void update(Permission permission) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(permission);
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public List<Permission> list(Role role) {
        List<Permission> result = new ArrayList<>();
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Query query = session.createQuery("from RolePermission where rId=:rid");
        query.setParameter("rid",role.getrId());
        List<RolePermission> list = query.list();
        for (RolePermission rolePermission:list){
            Permission permission = session.get(Permission.class, rolePermission.getpId());
            result.add(permission);
        }
        hibernateUtils.closeSession();
        return result;
    }

    @Override
    public Boolean needInterceptor(String requestURI) {
        List<Permission> list =list();
        for (Permission permission:list){
            if(permission.getUrl().equals(requestURI)){
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
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        for (Role role:list){
            Query query = session.createQuery("from RolePermission where rId=:rid");
            query.setParameter("rid",role.getrId());
            List<RolePermission> list1 = query.list();
            rolePermissionList.addAll(list1);
        }
        for (RolePermission rolePermission:rolePermissionList){
            Permission permission = session.get(Permission.class, rolePermission.getpId());
            result.add(permission.getUrl());
        }
        hibernateUtils.closeSession();
        return result;
    }

    @Override
    public List<Permission> list() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Query query = session.createQuery("from Permission ");
        List<Permission> list = query.list();
        hibernateUtils.closeSession();
        return list;
    }
}
