package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
			
			.csrf(csrf->csrf.disable());
		return http.build();
	}
}
