package com.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired MyDBAuthenticationService myDBAauthenticationService;
	 * 
	 * @Autowired public void configureGlebal(AuthenticationManagerBuilder auth)
	 * throws Exception { // Users in memory.
	 * auth.inMemoryAuthentication().withUser("user1").password("12345").roles(
	 * "USER"); auth.inMemoryAuthentication().withUser("admin1").password("12345").
	 * roles("USER, ADMIN");
	 * 
	 * // For User in database. auth.userDetailsService(myDBAauthenticationService);
	 * }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
			.antMatchers("/login", "/logout").permitAll();
			/*.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll();*/
	}
}
