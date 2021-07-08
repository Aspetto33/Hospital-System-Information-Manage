package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.entity.UserRole;
import com.jk18_7.sim.authority.interfaces.RoleDao;
import com.jk18_7.sim.authority.interfaces.RolePermissionDao;
import com.jk18_7.sim.login.entity.Users;
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

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    @Resource
    private LoginDao loginDao;
    @Resource
    private UserRoleDaoImpl userRoleDao;
    @Resource
    private RolePermissionDao rolePermissionDao;
    @Override
    public Set<String> listRoleNames(String uname) {
        Set<String> result = new HashSet<>();
        List<Role> roleList = listRoles(uname);
        for (Role role:roleList){
            result.add(role.getrName());
        }
        return result;
    }

    @Override
    public List<Role> listRoles(String uname) {
        List<Role> list = new ArrayList<>();
        Users users = loginDao.FindUserByName(uname);
        if(users == null)
            return null;
        list = list(users);
        return list;

    }

    @Override
    public List<Role> list(Users users) {
        List<Role> roleList = new ArrayList<>();
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Query query = session.createQuery("from UserRole where uId=:uid");
        query.setParameter("uid",users.getuId());
        List<UserRole> list = query.list();
        try {
            for (UserRole userRole:list) {
                query = session.createQuery("from Role where rId = :rid");
                query.setParameter("rid", userRole.getrId());
                List<Role> list1 = query.list();
                for (Role role : list1) {
                    roleList.add(role);
                }
            }
            hibernateUtils.closeSession();
            return roleList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Role> list() {
        try{
            HibernateUtils hibernateUtils = new HibernateUtils();
            Session session = hibernateUtils.getSession();
            Query query = session.createQuery("from Role");
            List list = query.list();
            if(list.size()>0){
                hibernateUtils.closeSession();
                return list;
            }else {
                //return null;
                return new ArrayList<Role>();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            //return null;
            return new ArrayList<Role>();
        }

    }

    @Override
    public void addRole(Role role) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public void deleteRole(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class,id);
        session.delete(role);
        userRoleDao.deleteByRole(id);
        rolePermissionDao.deleteByRole(id);
        transaction.commit();
        hibernateUtils.closeSession();
    }

    @Override
    public Role getRole(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Role role = session.get(Role.class,id);
        hibernateUtils.closeSession();
        return role;
    }

    @Override
    public void updateRole(Role role) {
        HibernateUtils hibernateUtils =new HibernateUtils();
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(role);
        transaction.commit();
        hibernateUtils.closeSession();
    }
}
