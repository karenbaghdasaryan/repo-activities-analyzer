package com.webbfontaine.repoactivitiesanalyzer.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatelessAuthenticationFilter extends GenericFilterBean {

	private final TokenAuthenticationService authenticationService;

	@Value("${jwt.token.header}")
	private String cookieName;

	public StatelessAuthenticationFilter(TokenAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
		throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Authentication authentication = authenticationService.getAuthentication(httpRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		filterChain.doFilter(request, httpServletResponse);
		SecurityContextHolder.getContext().setAuthentication(null);
	}
}
