package com.jk18_7.sim.authority.action;

import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.service.RoleService;
import com.jk18_7.sim.authority.service.UserRoleService;
import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {
    private Users users;
    @Resource
    private LoginService loginService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    private int id;

    //查询所有用户及其角色并将其展示在页面上
    public String listUser() {
        List<Users> users = loginService.getList();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("users", users);
        Map<Users, List<Role>> user_role = new HashMap<>();
        for (Users users1 : users) {
            List<Role> roles = roleService.list(users1);
            user_role.put(users1, roles);
        }
        actionContext.put("user_role", user_role);
        return "listUser";
    }

    //修改用户信息
    public String editUser() {
        Map<String, Object> actionContext = (Map<String, Object>) ActionContext.getContext();
        List<Role> roles = roleService.list();
        actionContext.put("roles", roles);
        Users users = loginService.getUser(id);
        actionContext.put("users", users);
        List<Role> roleList = roleService.list(users);
        actionContext.put("currentRole", roleList);
        return "editUser";
    }
//    public String updateUser(Users users,long []rids){
//       userRoleService.setRoles(users,rids);
//       String password = users.getuPwd();
//       if(users.getuPwd().length()!=0){
//           String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//           int times = 2;
//           String algorithmName = "md5";
//           String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
//           users.setSalt(salt);
//           users.setuPwd(encodedPassword);
//       }else {
//           users.setuPwd(null);
//       }
//       loginService.updateUser(users);
//        return "updateUser";
//    }
    public String addUser(){
        Users users = new Users();
        String password = users.getuPwd();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
        users.setSalt(salt);
        users.setuPwd(encodedPassword);
        loginService.AddUser(users);
        System.out.println(users.getuEmail()+users.getuPwd());
        return "addUser";
    }

    public String deleteUser(){
        loginService.delete(id);
        return "deleteUser";
    }
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
