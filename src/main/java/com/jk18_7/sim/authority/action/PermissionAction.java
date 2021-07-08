package com.jk18_7.sim.authority.action;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.service.PermissionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class PermissionAction extends ActionSupport {
    @Resource
    private PermissionService permissionService;
    private Permission permission;
    private int id;
    public String listPermission(){
        List<Permission> permission = permissionService.list();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("permission",permission);
        return "listPermission";
    }
    public String editPermission(){
        Permission permission = permissionService.getPermission(id);
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("permission",permission);
        return "editPermission";
    }
    public String updatePermission(){
        permissionService.update(permission);
        return "updatePermission";
    }
    public String addPermission(){
        permissionService.add(permission);
        return "addPermission";
    }
    public String deletePermission(){
        int pid = permission.getpId();
        permissionService.delete(pid);
        return "deletePermission";
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
