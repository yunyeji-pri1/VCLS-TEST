package com.neonexsoft.vclstest.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class VclsSecurityConfig  {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/aa").permitAll()
                .antMatchers("/css/**", "/js/**/**", "/image/**").permitAll()
                .anyRequest().authenticated()
            .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login/perform")
                    .defaultSuccessUrl("/main")
                    .failureUrl("/login");
        http.formLogin();
        http.httpBasic().disable();
        http.cors().disable();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }

}




