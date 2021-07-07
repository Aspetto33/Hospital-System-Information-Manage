package com.jk18_7.sim.authority.service;

import com.jk18_7.sim.authority.entity.Role;

public interface RolePermissionService {
    void setPermissions(Role role, int[] pids);
    void deleteByRole(int rid);
    void deleteByPermission(int pid);
}
