package com.jk18_7.sim.authority.service.impl;

import com.jk18_7.sim.authority.interfaces.UserRoleDao;
import com.jk18_7.sim.authority.service.UserRoleService;
import com.jk18_7.sim.login.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleDao userRoleDao;
    @Override
    public void setRoles(Users users, int[] rIds) {
        userRoleDao.setRoles(users,rIds);
    }

    @Override
    public void deleteByUser(int uid) {
        userRoleDao.deleteByUser(uid);
    }

    @Override
    public void deleteByRole(int rid) {
        userRoleDao.deleteByRole(rid);
    }
}
