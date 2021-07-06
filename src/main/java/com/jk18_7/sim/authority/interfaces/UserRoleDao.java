package com.jk18_7.sim.authority.interfaces;

import com.jk18_7.sim.login.entity.Users;

public interface UserRoleDao {
    void setRoles(Users users, long [] rIds);

    void deleteByUser(long uid);

    void deleteByRole(long rid);
}
