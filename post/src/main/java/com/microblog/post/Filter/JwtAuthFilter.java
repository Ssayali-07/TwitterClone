package com.microblog.post.Filter;

import java.io.IOException;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.microblog.post.JwtUtil.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtilObj;

	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException{
		
		System.out.println("jwt filter called");
		String email=null;
		String token=null;
		String authHeader = request.getHeader("Authorization");
		System.out.println("token"+authHeader);
		
		if(authHeader!=null && authHeader.startsWith("Bearer")) {
			token = authHeader.substring(7);
			try {
				email = jwtUtilObj.extractEmail(token);
				
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email,null, List.of());
				SecurityContextHolder.getContext().setAuthentication(authToken);
				System.out.println("auth set "+ SecurityContextHolder.getContext().getAuthentication());
				
				}catch (Exception e) {
					System.out.println("Invalid Token");
				}
		}
		
		
		
		filterChain.doFilter(request, response);
	}

}
