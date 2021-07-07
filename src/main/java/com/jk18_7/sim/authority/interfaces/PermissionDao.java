package com.jk18_7.sim.authority.interfaces;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.entity.Role;

import java.util.List;
import java.util.Set;

public interface PermissionDao {
    Set<String> listPermissions(String uname);
    void add(Permission permission);
    void delete(int id);
    Permission getPermission(int id);
    void update(Permission permission);
    List<Permission> list(Role role);
    Boolean needInterceptor(String requestURI);
    Set<String> listPermissionURLs(String uname);
    List<Permission> list();
}
