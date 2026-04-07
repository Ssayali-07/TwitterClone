package com.microblog.post.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.microblog.post.Filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtAuthFilter jwtAuthFilterObj;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http){
		http
//		    .csrf(AbstractHttpConfigurer::disable)
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.addFilterBefore(jwtAuthFilterObj, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
