package com.jk18_7.sim.authority.service;

import com.jk18_7.sim.login.entity.Users;

public interface UserRoleService {
    void setRoles(Users users, long [] rIds);

    void deleteByUser(long uid);

    void deleteByRole(long rid);
}
