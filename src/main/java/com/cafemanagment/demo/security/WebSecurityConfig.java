package com.cafemanagment.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/manager/**").hasAuthority("MANAGER")
                .antMatchers("/waiter/**").hasAuthority("WAITER")
                .antMatchers("/").hasAnyAuthority("MANAGER","WAITER")
                .antMatchers("/login").permitAll()
                .and()
                .formLogin()
                .successHandler(new AuthenticationSuccessHandlerImpl())
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .usernameParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
