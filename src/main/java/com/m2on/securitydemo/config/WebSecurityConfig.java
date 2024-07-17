package com.m2on.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/9:41
 * @Description:
 */
@Configuration
public class WebSecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new DBUserDetailsManager();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        auth->auth
                                .anyRequest()
                                .authenticated()


                ).formLogin(form -> form.loginPage("/login").permitAll()
                        .usernameParameter("myusername")
                        .passwordParameter("mypassword"))
                .build();
    }

}
