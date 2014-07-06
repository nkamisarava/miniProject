package com.springapp.config;

import com.springapp.service.UserService;
import com.springapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by св on 7/4/201.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ShaPasswordEncoder encoder;

    @Autowired

    private BCryptPasswordEncoder BEncoder;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	auth
	    .userDetailsService(userService)
	    .passwordEncoder(BEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf()
	    .disable()
	    .authorizeRequests()
	    .antMatchers("/", "/registration", "/addUser").permitAll()
	    .antMatchers("/**").access("hasRole('USER')")
	    .and().formLogin();

	http.formLogin()
	    .loginPage("/login")
	    .loginProcessingUrl("/j_spring_security_check")
	    .defaultSuccessUrl("/")
	    .failureUrl("/login?error")
	    .usernameParameter("j_username")
	    .passwordParameter("j_password")
	    .permitAll().and()
	.logout()
	    //.logoutUrl("login?logout")
	    .logoutSuccessUrl("/")
	    .permitAll()
	    .and();

    }

}
