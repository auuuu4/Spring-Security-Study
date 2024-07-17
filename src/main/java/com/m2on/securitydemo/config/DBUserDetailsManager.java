package com.m2on.securitydemo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m2on.securitydemo.dao.UserMapper;
import com.m2on.securitydemo.entity.User;
import com.m2on.securitydemo.util.Builder.UserDetailBuilder;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/19:16
 * @Description:
 */
@Component
public class DBUserDetailsManager implements UserDetailsService, UserDetailsManager {
    @Autowired
    UserMapper userMapper;
    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null)
            throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        return UserDetailBuilder.build(user.getUsername(),user.getPassword(),!user.isEnabled(),false,false,false,authorities);

    }
}
