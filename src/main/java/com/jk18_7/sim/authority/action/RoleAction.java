package com.jk18_7.sim.authority.action;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.entity.Role;
import com.jk18_7.sim.authority.service.PermissionService;
import com.jk18_7.sim.authority.service.RolePermissionService;
import com.jk18_7.sim.authority.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleAction extends ActionSupport {
    @Resource
    private RoleService roleService;
    @Resource
    private RolePermissionService rolePermissionService;
    @Resource
    private PermissionService permissionService;

    private Role role;
    private int id;
    public String listRole(){
        List<Role> roles = roleService.list();
        ActionContext actionContext =  ActionContext.getContext();
        actionContext.put("roles",roles);
        Map<Role,List<Permission>> role_permission = new HashMap<>();
        for (Role role:roles){
            List<Permission> permissions = permissionService.list(role);
            role_permission.put(role,permissions);
        }
        actionContext.put("role_permission",role_permission);
        return "listRole";
    }
    public String editRole(){
        int rid = role.getrId();
        Role role = roleService.getRole(rid);
        Map<String,Object> actionContext = (Map<String, Object>) ActionContext.getContext();
        actionContext.put("role",role);
        List<Permission> permissionList = permissionService.list(role);
        actionContext.put("currentPermission",permissionList);
        return "editRole";
    }
//    public String updateRole(long[] pids){
//        rolePermissionService.setPermissions(role,pids);
//        roleService.updateRole(role);
//        return "updateRole";
//    }
    public String addRole(){
        roleService.addRole(role);
        return "addRole";
    }
    public String deleteRole(){
        try {
            int rid = role.getrId();
            roleService.deleteRole(rid);
            return "deleteRole";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
