package com.jk18_7.sim.authority.service;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.login.entity.Users;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

public interface RoleService {
    @Resource
    Set<String> listRoleNames(String uname);
    List<Role> listRoles(String uname);
    List<Role> list(Users users);
    List<Role> list();
    void addRole(Role role);
    void deleteRole(int id);
    Role getRole(int id);
    void updateRole(Role role);
}
