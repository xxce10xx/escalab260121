package com.cgbh.microservices.security.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);

	}

	/*
	 * @Autowired public void globalUserDetails(final AuthenticationManagerBuilder
	 * auth) throws Exception { auth.jdbcAuthentication().dataSource(dataSource); }
	 */

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
	
//	@Override 
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.sessionManagement().sessionFixation().none().and().httpBasic().disable();
//	}
}
