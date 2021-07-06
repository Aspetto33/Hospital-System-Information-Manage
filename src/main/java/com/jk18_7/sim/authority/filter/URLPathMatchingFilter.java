package com.jk18_7.sim.authority.filter;

import com.jk18_7.sim.authority.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.annotation.Resource;
import java.util.Set;

public class URLPathMatchingFilter extends PathMatchingFilter {
    @Resource
    private PermissionService permissionService;

    @Override
    protected boolean onPreHandle(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, Object mappedValue) throws Exception {
        String requestURI = getPathWithinApplication(request);
        System.out.println("requestURI:"+requestURI);
        Subject subject = SecurityUtils.getSubject();
        //如果没有登录，就跳转到登录页面
        if(!subject.isAuthenticated()){
            WebUtils.issueRedirect(request,response,"/login.jsp");
        }
        //判断数据库里是否有此路径，若没有则放行,也可以不放行
        boolean needInterceptor = permissionService.needInterceptor(requestURI);
        if(!needInterceptor){
            return true;
        }else {
            //此路径若在数据库中，则判断是否有对应的权限，若有则放行
            boolean hasPermission = false;
            String uname = subject.getPrincipal().toString();
            Set<String> permissionUrls = permissionService.listPermissionURLs(uname);
            for (String url:permissionUrls){
                if(url.equals(requestURI)){
                    hasPermission = true;
                    break;
                }
            }
            if(hasPermission){
                return true;
            }else {
                //此路径在数据库中，但没有对应的权限，因此提示没有访问路径的权限，并跳转到“unauthorized”页面
                UnauthenticatedException exception = new UnauthenticatedException("当前用户没有访问路径"+requestURI+"的权限");
                subject.getSession().setAttribute("exception",exception);
                WebUtils.issueRedirect(request,response,"/unauthorized.jsp");
                return false;
            }
        }
    }
}
