package com.ecommerce.config;

import java.security.NoSuchAlgorithmException;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	private String secretKey = "";

	private SecretKey generateSecretKey() {

		byte[] keybyte = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keybyte);
	}

	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().claims(claims).subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000000)).signWith(generateSecretKey())

				.compact();
	}

	public JWTService() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException(e);
		}

	}

	public String extractUsername(String jwt) {
		Claims claims = getClaims(jwt);

		return claims.getSubject();
	}

	private Claims getClaims(String jwt) {
		return Jwts.parser().verifyWith(generateSecretKey()).build().parseSignedClaims(jwt).getPayload();
	}

	public boolean isTokenValid(String jwt) {
		Claims claims = getClaims(jwt);
		return claims.getExpiration().after(Date.from(Instant.now()));
	}

}
