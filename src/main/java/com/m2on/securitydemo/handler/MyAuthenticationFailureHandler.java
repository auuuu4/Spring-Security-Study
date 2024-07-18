package com.m2on.securitydemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:19
 * @Description:
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(
                Jackson2Util.parseJSONString(HttpResult.fail("message: "+exception.getLocalizedMessage()))
        );
    }
}
