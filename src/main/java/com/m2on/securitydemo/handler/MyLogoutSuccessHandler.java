package com.m2on.securitydemo.handler;

import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:26
 * @Description:
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
        response.getWriter().write(Jackson2Util.parseJSONString(HttpResult.success("登出成功")));
    }
}
