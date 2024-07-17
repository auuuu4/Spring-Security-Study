package com.m2on.securitydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m2on.securitydemo.dao.UserMapper;
import com.m2on.securitydemo.entity.User;
import com.m2on.securitydemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/12:39
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
