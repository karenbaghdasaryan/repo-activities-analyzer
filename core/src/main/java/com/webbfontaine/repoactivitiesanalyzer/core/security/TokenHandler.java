package com.webbfontaine.repoactivitiesanalyzer.core.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public final class TokenHandler {
    private final String secret;
    private final UserDetailsService userService;

    public TokenHandler(String secret, UserDetailsService userService) {
        this.secret = secret;
        this.userService = userService;
    }

    public UserDetails parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userService.loadUserByUsername(username);
    }

    public String createTokenForUser(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String createTokenForUser(String key) {
        return Jwts.builder()
                .setSubject(key)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
