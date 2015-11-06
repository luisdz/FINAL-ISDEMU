/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Jose Eduardo
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    @Qualifier("customUserDetailsService")//inyectas a spring el servcio
    UserDetailsService userDetailsService;
    
        @Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	//auth.inMemoryAuthentication().withUser("bill").password("123456").roles("ADMIN");
         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
      	}
        	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
                  
             // .antMatchers("/inventario/**").access("hasRole('ADMIN')")
              .antMatchers("/Depreciacion/**").access("hasRole('ADMIN')")
              .antMatchers("/confidential/**").access("hasRole('ADMIN')")
	      .and().formLogin()
              .loginProcessingUrl("/j_spring_security_check")
              .loginPage("/login").failureUrl("/login?error")
              .defaultSuccessUrl("/index")
              .usernameParameter("username").passwordParameter("password")
              .and()
              .logout().logoutSuccessUrl("/login?logout") 
              .and().csrf().disable()
               ;
                        
          
 
	}
    
}
