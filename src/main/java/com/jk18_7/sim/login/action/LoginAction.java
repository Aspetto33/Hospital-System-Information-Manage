package com.jk18_7.sim.login.action;

import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

public class LoginAction extends ActionSupport implements ModelDriven<Users> {
    private Users users;
    @Resource
    private LoginService loginService;
    private String newupwd;

    //login
    public String findUserByUnameAndUpwd(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getuName(),users.getuPwd());
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject",subject);
            System.out.println(subject);
            return SUCCESS;
        }catch (AuthenticationException e){
            Map<String,Object> session =  ActionContext.getContext().getSession();
            session.put("error","验证失败");
            return ERROR;
        }
//       Users users1 = loginService.FindUserByName(users.getuName());
//       System.out.println(users1);
//       String salt = users1.getSalt();
//       System.out.println(salt);
//       int times = 2;
//       String algorithmName = "md5";
//       String encodedPassword = new SimpleHash(algorithmName,users.getuPwd(),salt,times).toString();
//       System.out.println(encodedPassword);
//       String password = loginService.getPassword(users.getuName());
//       System.out.println(password);
//       if(encodedPassword.equals(password)){
//           return SUCCESS;
//       }else {
//           return ERROR;
//       }
    }

    public String addUser(){
        try{
            loginService.AddUser(users);
            return "addUser";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "addUserF";
        }

    }
    public String updateUpwd(){
        try {
            String newpwd = loginService.UpdateUpwd(users.getuName(),users.getuPwd(),newupwd);
            System.out.println(newpwd);
            return "updateUpwd";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "updateUpwdF";
        }

    }
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }

    public String getNewupwd() {
        return newupwd;
    }

    public void setNewupwd(String newupwd) {
        this.newupwd = newupwd;
    }

    @Override
    public Users getModel() {
        users = new Users();
        return users;
    }
}
