package com.bulatovda.esport.modules.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public class JwtTokenRepository implements CsrfTokenRepository {
	@Value("${esport.jwt.private}")
	private String secret;

	@Value("${esport.jwt.validTime}")
	private int validTime;

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		String id = UUID.randomUUID().toString().replace("-", "");
		Date now = new Date();
		Date exp = Date.from(LocalDateTime.now().plusMinutes(validTime)
				.atZone(ZoneId.systemDefault()).toInstant());
		String token = "";
		try {
			token = Jwts.builder()
					.setId(id)
					.setIssuedAt(now)
					.setNotBefore(now)
					.setExpiration(exp)
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
		} catch (JwtException e) {
			e.printStackTrace();
		}
		return new DefaultCsrfToken("x-csrf-token", "_csrf", token);
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		return null;
	}
}
