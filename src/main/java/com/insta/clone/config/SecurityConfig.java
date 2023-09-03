package com.insta.clone.config;


import com.insta.clone.jwt.JwtAuthenticationFilter;
import com.insta.clone.jwt.JwtTokenProvider;
import com.insta.clone.jwt.JwtUserService;
import com.insta.clone.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthMapper authMapper;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider() throws Exception {
        return new JwtTokenProvider(memberService());
    }
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(jwtTokenProvider());
    }
    @Bean
    public JwtUserService memberService() throws Exception {
        return new JwtUserService(authMapper, passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.exceptionHandling().disable();

        http.authorizeRequests()
                .antMatchers("/auth/loginForm", "/auth/joinForm", "/**", "/login").permitAll() // 모든 사용자에게 접근 허용
                .antMatchers("/", "/user/**", "/image/**", "/follow/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") // user 권한 또는 admin 권한이 있는 사용자에게 접근 허용
                .antMatchers("/user/{userId}").authenticated()
                .antMatchers("/image/upload").authenticated()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // admin 권한이 있는 사용자에게만 접근 허용
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/auth/loginForm")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true);
    }
}
