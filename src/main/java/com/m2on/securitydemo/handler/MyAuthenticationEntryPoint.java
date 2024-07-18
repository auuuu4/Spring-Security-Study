package com.m2on.securitydemo.handler;

import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:32
 * @Description:
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(Jackson2Util.parseJSONString(HttpResult.fail(403,"请先登录")));
    }
}
