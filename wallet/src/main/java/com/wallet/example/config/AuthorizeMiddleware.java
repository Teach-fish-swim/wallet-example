package com.wallet.example.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验
 */
public class AuthorizeMiddleware implements HandlerInterceptor {

    public AuthorizeMiddleware() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进行一些系列的验证
        //1.url验证,
        //2. 白名单验证，
        //3. token验证
        //.....
        return true;
    }
}