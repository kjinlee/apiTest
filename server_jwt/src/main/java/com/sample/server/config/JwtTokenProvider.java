package com.sample.server.config;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider { // 토큰 생성 및 유효성 검증 컴포넌트

	public final static long TOKEN_VALIDATION_SECOND = 1000L * 10;
	public final static long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;

	final static public String ACCESS_TOKEN_NAME = "accessToken";
	
	// 토큰 체크 시 필요한 암호
	private static final String secretKey = "secretKey";

	private final UserDetailsService userDetailsService;

	// 토큰 생성
	public String createToken(String name, String role) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);

		// payload 부분에 들어갈 정보 조각들
		Claims claims = Jwts.claims().setSubject(name);
		claims.put("role", role);
		return Jwts.builder().setIssuedAt(new Date()).setExpiration(new Date(cal.getTimeInMillis()))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();

	}

	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUser(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	public String getUser(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest req) {
		return req.getHeader("X-AUTH-TOKEN");
	}

	// 토큰 유효성 확인
	public boolean checkClaim(String jwt) {
		try {
			Claims claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(jwt).getBody();

			return true;

			// 토근 만료 시
		} catch (ExpiredJwtException e) {
			System.out.println("Token Expired");
			return false;

			// 토근 변조 시
		} catch (JwtException e) {
			System.out.println("Token error");
			return false;
		}

	}

	// token에 담긴 claim 반환
	public Claims getClaims(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(jwt).getBody();

		return claims;
	}

}
