package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
			)
			//.formLogin(withDefaults())
			//.httpBasic(withDefaults());
			.formLogin(form->
					form.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.usernameParameter("member")
					.passwordParameter("password")
					.defaultSuccessUrl("/menu",true)
					.successHandler(mySuccessHandler())
					
					.permitAll()
			)
			
			.csrf(csrf->csrf.disable())
			.logout().permitAll()
		
			
		;
		return http.build();
	}
	
	

	private AuthenticationSuccessHandler mySuccessHandler() {
		return new MYAuthenticationSuccessHandler();
	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
