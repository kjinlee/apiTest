package com.sample.server.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;

public class JwtAuthenticationFilter extends GenericFilterBean {

	private JwtTokenProvider JwtTokenProvider;

	public JwtAuthenticationFilter(JwtTokenProvider JwtTokenProvider) {
		this.JwtTokenProvider = JwtTokenProvider;
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String token = JwtTokenProvider.resolveToken((HttpServletRequest) request);

		// 권한이 있으면 session에 저장
		if (token != null && JwtTokenProvider.checkClaim(token)) {
			Authentication auth = JwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(auth);;
		}

		chain.doFilter(request, response);

	}
}
