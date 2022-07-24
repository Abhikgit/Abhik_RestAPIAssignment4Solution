package com.greatlearning.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagement.service.EmployeeUserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EmployeeWebSecurityConfigurerAdapter 
	extends WebSecurityConfigurerAdapter{

	// Customize Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		AuthenticationProvider authenticationProvider = customAuthenticationProvider();
		auth.authenticationProvider(authenticationProvider);
		
	}
	
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new EmployeeUserDetailsService();
}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider customAuthenticationProvider() {
		
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		
		daoProvider.setUserDetailsService(customUserDetailsService());
		daoProvider.setPasswordEncoder(bcryptPasswordEncoder());
		
		return daoProvider;
	}
	
	//  Customize the Authorization
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/", "/employee/save", "/employee/add-begin", "/employee/403")
				.hasAnyAuthority("NORMAL_USER", "ADMIN_USER")

			.antMatchers("/employee/update-begin", "/employee/delete")
				.hasAuthority("ADMIN_USER")
			.anyRequest().authenticated().and()
			.formLogin()
				.loginProcessingUrl("/login").successForwardUrl("/employees/list")
			.permitAll().and().
			logout()
				.logoutSuccessUrl("/login").permitAll().and().
			exceptionHandling()
				.accessDeniedPage("/employees/403").and()
			.cors().and().csrf().disable();
	}	
	
}

