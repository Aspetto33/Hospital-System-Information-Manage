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

    private int []rids;

    //查询所有用户及其角色并将其展示在页面上
    public String listUser() {
        List<Users> users = loginService.getList();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("users", users);
        Map<Users, List<Role>> user_role = new HashMap<Users, List<Role>>();
        for (Users users1 : users) {
            if(users1!=null){
                List<Role> roles = roleService.list(users1);
                user_role.put(users1, roles);
            }
        }
        actionContext.put("user_role", user_role);
        return "listUser";
    }

    //修改用户信息
    public String editUser() {
        ActionContext actionContext = ActionContext.getContext();
        List<Role> roles = roleService.list();
        actionContext.put("roles", roles);
        Users users = loginService.getUser(id);
        actionContext.put("users", users);
        List<Role> roleList = roleService.list(users);
        actionContext.put("currentRole", roleList);
        return "editUser";
    }
    public String updateUser(){
        Users users = loginService.getUser(id);
       userRoleService.setRoles(users,rids);
        return "updateUser";
    }
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

    public int[] getRids() {
        return rids;
    }

    public void setRids(int[] rids) {
        this.rids = rids;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserRoleService getUserRoleService() {
        return userRoleService;
    }

    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }


}
