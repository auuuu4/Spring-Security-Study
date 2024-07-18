package com.m2on.securitydemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.entity.User;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:08
 * @Description:
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(
                Jackson2Util.parseJSONString(HttpResult.success(
                        "username: "+authentication.getPrincipal()
                                +"， password: "+authentication.getCredentials()
                                +"， grantedAuthority: "+objectMapper.writeValueAsString(authentication.getAuthorities())
                ))

        );
    }


}
