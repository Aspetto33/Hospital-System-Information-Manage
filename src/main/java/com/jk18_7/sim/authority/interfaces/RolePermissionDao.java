package com.jk18_7.sim.authority.interfaces;

import com.jk18_7.sim.authority.entity.Role;

public interface RolePermissionDao {
    void setPermissions(Role role,long[] pids);
    void deleteByRole(long rid);
    void deleteByPermission(long pid);
}
