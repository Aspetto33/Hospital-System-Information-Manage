package com.jk18_7.sim.login.service;

import com.jk18_7.sim.login.entity.Users;

import java.util.List;

public interface LoginService {
    //find users and change logintime
    Boolean FindUserByUnameAndUpwd(String uname,String upwd);

    //register function
    void AddUser(Users users);

    //update password function
    String UpdateUpwd(String uname, String upwd, String newupwd);

    //add logintime
//    void AddLoginTime(Logintime logintime, Integer uid);

    //find users function
    Users FindUserByName(String uname);

    String getPassword(String uname);

    void updateUser(Users users);

    Users getUser(long uid);

    List<Users> getList();

    void delete(int id);

}
