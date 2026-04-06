package com.microblog.login_signup.SecurityUtil;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	public String secret = "my-super-secret-key-that-is-long-enough-1234567890!@#"; // must be 256 bytes

	private SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

	// create jwt token
	public String generateToken(String email) {
		return Jwts.builder()
				.subject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1hour from hitting time
				.signWith(key)
				.compact();

	}

	// extract email from token to validate user
	public String extractEmail(String token) {
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();

	}
}
