package com.jk18_7.sim.authority.dao;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.entity.UserRole;
import com.jk18_7.sim.authority.interfaces.RoleDao;
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
   @Resource(name="sessionFactory")
   private SessionFactory sessionFactory;
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
            return list;
        list = list(users);
        return list;

    }

    @Override
    public List<Role> list(Users users) {
        List<Role> roleList = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserRole where uId=:uid");
        query.setParameter("uid",users.getuId());
        List<UserRole> list = query.list();
        for (UserRole userRole:list){
            query = session.createQuery("from Role where rId = :rid");
            query.setParameter("rid",userRole.getrId());
            List<Role> list1 = query.list();
            for (Role role:list1){
                roleList.add(role);
            }
        }
        return roleList;
    }

    @Override
    public List<Role> list() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Role");
        List list = query.list();
        if(list.size()<=0||list==null)
            return null;
        return list;

    }

    @Override
    public void addRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
    }

    @Override
    public void deleteRole(long id) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class,id);
        session.delete(role);
        transaction.commit();
    }

    @Override
    public Role getRole(long id) {
        return null;
    }

    @Override
    public void updateRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(role);
        transaction.commit();
    }
}