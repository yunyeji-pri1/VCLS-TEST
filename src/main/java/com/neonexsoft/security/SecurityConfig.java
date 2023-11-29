package com.neonexsoft.security;

import com.neonexsoft.security.jwt.JwtAccessDeniedHandler;
import com.neonexsoft.security.jwt.JwtAuthenticationEntryPoint;
import com.neonexsoft.security.jwt.JwtSecurityConfig;
import com.neonexsoft.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    //패스워드 암호화시 사용
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //h2-console, favicon, swagger-ui  시큐리티에 필터에 걸리지않도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/h2-console/**", //h2 console
                        "/favicon.ico"
                        );
    }

    //http 요청에대한 권한 제한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                //세션 사용하지 않으므로 STATELESS 로 지정
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/api/hello/**").permitAll() //hello 테스트  > 전체허용
                .antMatchers("/api/auth/**").permitAll() //로그인  > 전체허용
                .antMatchers("/api/join/**").permitAll() //회원가입  > 전체허용
                .anyRequest().authenticated()

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }
}
