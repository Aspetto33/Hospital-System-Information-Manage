package com.jk18_7.sim.authority.action;

import com.jk18_7.sim.authority.entity.Permission;
import com.jk18_7.sim.authority.service.PermissionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Map;

public class PermissionAction extends ActionSupport {
    @Resource
    private PermissionService permissionService;
    private Permission permission;
    public String listPermission(){
        long pid = permission.getpId();
        Permission permission = permissionService.getPermission(pid);
        Map<String,Object> actionContext = (Map<String, Object>) ActionContext.getContext();
        actionContext.put("permission",permission);
        return "listPermission";
    }
    public String updatePermission(){
        permission = new Permission();
        permissionService.update(permission);
        return "updatePermission";
    }
    public String addPermission(){
        Permission permission = new Permission();
        permissionService.add(permission);
        return "addPermission";
    }
    public String deletePermission(){
        long pid = permission.getpId();
        permissionService.delete(pid);
        return "deletePermission";
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
