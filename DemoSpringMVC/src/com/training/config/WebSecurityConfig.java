package com.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("MyUserDetailsServiceImpl")
	UserDetailsService MyUserDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("MEMBER");
        auth.userDetailsService(MyUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
        
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web
    		.ignoring()
    			.antMatchers("/WEB-INF/views/**"); 
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/", "/item/*","/item", "/cart", "/category/*", "/category").hasAnyAuthority("MEMBER", "ADMIN")
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error=true")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403");
	}
}
