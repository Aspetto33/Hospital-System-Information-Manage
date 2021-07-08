package com.jk18_7.sim.login.service.impl;

import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.interfaces.LoginDao;
import com.jk18_7.sim.login.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    @Override
    public Boolean FindUserByUnameAndUpwd(String uname, String upwd) {
        return loginDao.FindUserByUnameAndUpwd(uname, upwd);
    }


    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public void AddUser(Users users) {
        loginDao.AddUser(users);
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public String UpdateUpwd(String uname, String upwd, String newupwd) {
        return loginDao.UpdateUpwd(uname, upwd, newupwd);
    }

    @Override
    public Users FindUserByName(String uname) {
        return loginDao.FindUserByName(uname);
    }

    @Override
    public String getPassword(String uname) {
        return loginDao.getPassword(uname);
    }

    @Override
    public void updateUser(Users users) {
        loginDao.updateUser(users);
    }

    @Override
    public Users getUser(int uid) {
        return loginDao.getUser(uid);
    }

    @Override
    public List<Users> getList() {
        return loginDao.getList();
    }

    @Override
    public void delete(int id) {
        loginDao.delete(id);
    }
//    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
//    @Override
//    public void AddLoginTime(Logintime logintime, Integer uid) {
//        loginDao.AddLoginTime(logintime,uid);
//    }

}
