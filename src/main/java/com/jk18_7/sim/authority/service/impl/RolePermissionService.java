package com.jk18_7.sim.authority.service.impl;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.interfaces.RolePermissionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("rolePermissionService")
public class RolePermissionService implements com.jk18_7.sim.authority.service.RolePermissionService {
   @Resource
   private RolePermissionDao rolePermissionDao;
    @Override
    public void setPermissions(Role role, long[] pids) {
        rolePermissionDao.setPermissions(role,pids);
    }

    @Override
    public void deleteByRole(long rid) {
        rolePermissionDao.deleteByRole(rid);
    }

    @Override
    public void deleteByPermission(long pid) {
        rolePermissionDao.deleteByPermission(pid);
    }
}
