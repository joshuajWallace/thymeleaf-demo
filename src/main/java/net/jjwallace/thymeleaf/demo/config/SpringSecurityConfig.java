package net.jjwallace.thymeleaf.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/employees/list/**").hasAnyRole("EMPLOYEE, ADMIN")
		.antMatchers("/employee/**").hasRole("ADMIN")
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login").permitAll()
		.and().logout()
		.invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override 
	public void configure(AuthenticationManagerBuilder auth) 
	throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource);
		
	}

}
