package com.m2on.securitydemo.config;

import com.m2on.securitydemo.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/9:41
 * @Description:
 */
//@Configuration
//@EnableMethodSecurity
public class WebSecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new DBUserDetailsManager();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 登录需要关闭csrf否则报 403
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity
                .authorizeHttpRequests(
                        auth->auth
//                                .requestMatchers("/**").hasRole("ADMIN")
//                                .requestMatchers("/userlist").hasAnyAuthority("USER_LIST")
//                                .requestMatchers("/test").hasAnyAuthority("TEST")
                                .anyRequest()
                                .authenticated()
                ).formLogin(form -> form
                        .loginProcessingUrl("/").permitAll()
//                        .usernameParameter("myusername")
//                        .passwordParameter("mypassword")
                        .successHandler(new MyAuthenticationSuccessHandler())
                        .failureHandler(new MyAuthenticationFailureHandler())
                ).logout(logout -> logout.logoutSuccessHandler(new MyLogoutSuccessHandler()))
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                        .accessDeniedHandler(new MyAccessDeniedHandler())
                )
                .sessionManagement(sessionManagement -> sessionManagement.maximumSessions(1).expiredSessionStrategy(new MySessionInformationExpireStrategy()))
                .build();
    }

}
