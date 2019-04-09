package com.webbfontaine.repoactivitiesanalyzer.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TokenAuthenticationService {
    private final TokenHandler tokenHandler;
    private String headerName;

    public TokenAuthenticationService(@Value("${jwt.token.secret}") String secret,
                                      @Value("${jwt.token.header}") String headerName,
                                      UserDetailsService userDetailsService) {
        this.headerName = headerName;
        this.tokenHandler = new TokenHandler(secret, userDetailsService);
    }

    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final UserDetails user = authentication.getPrincipal();
        response.addHeader(headerName, tokenHandler.createTokenForUser(user));
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerName);
        if (token != null) {
        	if (token.startsWith("Bearer ")) {
        		token = token.substring(7);
			}
            final UserDetails user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }
}
