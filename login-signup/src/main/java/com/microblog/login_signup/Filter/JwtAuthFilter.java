package com.microblog.login_signup.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.microblog.login_signup.SecurityUtil.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtUtil jwtUtilObj;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException{
		String authHeader = request.getHeader("Authorization");
		if(authHeader!=null && authHeader.startsWith("Bearer")) {
			String token = authHeader.substring(7);
			String email = jwtUtilObj.extractEmail(token);
		}
		filterChain.doFilter(request, response);
	}
}
