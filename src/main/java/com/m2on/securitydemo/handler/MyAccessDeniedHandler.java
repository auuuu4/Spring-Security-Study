package com.m2on.securitydemo.handler;

import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/18/9:26
 * @Description:
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(Jackson2Util.parseJSONString(HttpResult.fail("权限不足")));
    }
}
