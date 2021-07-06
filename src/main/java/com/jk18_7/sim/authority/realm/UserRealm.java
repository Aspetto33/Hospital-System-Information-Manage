package com.jk18_7.sim.authority.realm;

import com.jk18_7.sim.authority.service.PermissionService;
import com.jk18_7.sim.authority.service.RoleService;
import com.jk18_7.sim.login.entity.Users;
import com.jk18_7.sim.login.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //账号已经通过验证
        String uname = (String)principalCollection.getPrimaryPrincipal();
        //通过servcie获取权限和角色
        Set<String> permissions = permissionService.listPermissions(uname);
        Set<String> roles = roleService.listRoleNames(uname);
        //授权对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将获取到的权限和角色名放进去
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName= token.getPrincipal().toString();
        //获取数据库中的密码
        Users users =loginService.FindUserByName(userName);
        String passwordInDB = users.getuPwd();
        String salt = users.getSalt();
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :userRealm
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,passwordInDB,ByteSource.Util.bytes(salt),getName());
        return a;
    }
}
