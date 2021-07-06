package com.jk18_7.sim.authority.service;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.login.entity.Users;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<String> listRoleNames(String uname);
    List<Role> listRoles(String uname);
    List<Role> list(Users users);
    List<Role> list();
    void addRole(Role role);
    void deleteRole(long id);
    Role getRole(long id);
    void updateRole(Role role);
}
