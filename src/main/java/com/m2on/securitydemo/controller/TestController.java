package com.m2on.securitydemo.controller;

import com.m2on.securitydemo.entity.User;
import com.m2on.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RestController
public class TestController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public List<User> root(HttpServletResponse response) throws IOException {
        return userService.list();
    }
}
