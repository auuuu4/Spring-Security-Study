package com.m2on.securitydemo.handler;

import com.m2on.securitydemo.entity.HttpResult;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/18/8:40
 * @Description:
 */
public class MySessionInformationExpireStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(Jackson2Util.parseJSONString(HttpResult.fail(-1,"该账号已在其他设备登录")));
    }
}
