package com.sample.server.config;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sample.server.service.CustomUserDetails;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetails userDetailsService;

	@Autowired
	private JwtTokenProvider jwtUtil;

	@Autowired
	private CookieUtil cookieUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		final Cookie jwtToken = cookieUtil.getCookie(httpServletRequest, jwtUtil.ACCESS_TOKEN_NAME);

		String username = null;
		String jwt = null;
		try {
			if (jwtToken != null) {
				jwt = jwtToken.getValue();
				username = jwtUtil.getUser(jwt);
			}
			if (username != null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);

				if (jwtUtil.checkClaim(jwt)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
