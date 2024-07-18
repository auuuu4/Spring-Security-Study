package com.m2on.securitydemo.controller;

import com.m2on.securitydemo.entity.User;
import com.m2on.securitydemo.service.UserService;
import com.m2on.securitydemo.util.Jackson2Util;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/9:39
 * @Description:
 */
@Controller
public class TestController {
    @Autowired
    UserService userService;
    @PreAuthorize("hasAnyRole('USER_LIST')")
    @GetMapping("/userlist")
    public void userList(HttpServletResponse response) throws IOException {
        response.getWriter().write(Jackson2Util.parseJSONString(userService.list()));
    }
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @GetMapping("/")
    public String index(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                        @AuthenticationPrincipal OAuth2User oauth2User) {
        model.addAttribute("userName", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        return "index";
    }
    @GetMapping("/github")
    public void github(HttpServletRequest request){

    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public void admin(HttpServletResponse response) throws IOException {
        response.getWriter().write("admin");
    }
}
