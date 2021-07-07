package com.jk18_7.sim.authority.service.impl;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.interfaces.PermissionDao;
import com.jk18_7.sim.authority.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;
    @Override
    public Set<String> listPermissions(String uname) {
        return permissionDao.listPermissions(uname);
    }

    @Override
    public void add(Permission permission) {
        permissionDao.add(permission);
    }

    @Override
    public void delete(int id) {
        permissionDao.delete(id);
    }

    @Override
    public Permission getPermission(int id) {
        return permissionDao.getPermission(id);
    }

    @Override
    public void update(Permission permission) {
        permissionDao.update(permission);
    }

    @Override
    public List<Permission> list(Role role) {
        return permissionDao.list(role);
    }

    @Override
    public Boolean needInterceptor(String requestURI) {
        return permissionDao.needInterceptor(requestURI);
    }

    @Override
    public Set<String> listPermissionURLs(String uname) {
        return permissionDao.listPermissionURLs(uname);
    }

    @Override
    public List<Permission> list() {
        return permissionDao.list();
    }
}
