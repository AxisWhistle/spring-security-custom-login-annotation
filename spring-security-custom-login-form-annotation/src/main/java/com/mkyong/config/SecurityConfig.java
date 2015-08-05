package com.mkyong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("mkyong").password("123456")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("office").password("123456")
				.roles("OFFICE");
		auth.inMemoryAuthentication().withUser("manager").password("123456")
				.roles("MANAGER");
		auth.inMemoryAuthentication().withUser("deparment").password("123456")
				.roles("department");
	}

	// .csrf() is optional, enabled by default, if using
	// WebSecurityConfigurerAdapter constructor
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/office/**")
				.access("hasRole('ROLE_OFFICE')").antMatchers("/manager/**")
				.access("hasRole('ROLE_MANAGER')")
				.antMatchers("/department/**")
				.access("hasRole('ROLE_DEPARTMENT')").antMatchers("/admin/**")
				.access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")

				.and().logout().logoutSuccessUrl("/login?logout").and().csrf();

	}
}