package com.jk18_7.sim.authority.service;

import com.jk18_7.sim.authority.entity.Role;

public interface RolePermissionService {
    void setPermissions(Role role, long[] pids);
    void deleteByRole(long rid);
    void deleteByPermission(long pid);
}
