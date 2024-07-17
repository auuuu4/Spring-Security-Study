package com.m2on.securitydemo.util.Builder;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/21:07
 * @Description:
 */
public class UserDetailBuilder {
    public static UserDetails build(String username, String password,
                                    boolean disabled, boolean accountExpired, boolean accountLocked, boolean credentialsExpired, Collection<GrantedAuthority> authorities){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return User.builder()
                .passwordEncoder(encoder::encode)
                .username(username)
                .password(password)
                .disabled(disabled)
                .accountExpired(accountExpired)
                .credentialsExpired(credentialsExpired)
                .accountLocked(accountLocked)
                .build();

    }
}
