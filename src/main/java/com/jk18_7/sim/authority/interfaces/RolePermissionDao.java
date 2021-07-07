package com.jk18_7.sim.authority.interfaces;

import com.jk18_7.sim.authority.entity.Role;

public interface RolePermissionDao {
    void setPermissions(Role role, int[] pids);
    void deleteByRole(int rid);
    void deleteByPermission(int pid);
}
