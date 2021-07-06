package com.jk18_7.sim.authority.exception;

import com.opensymphony.xwork2.ActionContext;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ActionContext processUnauthenticatedException(NativeWebRequest request,UnauthorizedException e){
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("ex",e);
        return actionContext;
    }
}
