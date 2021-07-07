package com.jk18_7.sim.authority.service.impl;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.interfaces.RoleDao;
import com.jk18_7.sim.authority.service.RoleService;
import com.jk18_7.sim.login.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    @Override
    public Set<String> listRoleNames(String uname) {
        return roleDao.listRoleNames(uname);
    }

    @Override
    public List<Role> listRoles(String uname) {
        return roleDao.listRoles(uname);
    }

    @Override
    public List<Role> list(Users users) {
        return roleDao.list(users);
    }

    @Override
    public List<Role> list() {
        return roleDao.list();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }
}
