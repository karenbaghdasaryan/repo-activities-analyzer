package com.webbfontaine.repoactivitiesanalyzer.core.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenAuthenticationService tokenAuthenticationService;
    private final UserDetailsService userDetailsService;

    public StatelessLoginFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService,
                                UserDetailsService userDetailsService, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(urlMapping));
        this.userDetailsService = userDetailsService;
        this.tokenAuthenticationService = tokenAuthenticationService;
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        final AuthenticationCredentials credentials = new ObjectMapper().readValue(request.getInputStream(),
                AuthenticationCredentials.class);
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(), credentials.getPassword());
        UserAuthentication userAuthentication = null;
        Authentication authentication = getAuthenticationManager().authenticate(loginToken);
        if (authentication != null) {
            userAuthentication = new UserAuthentication((UserDetails) authentication.getPrincipal());
        }
        return userAuthentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException, ServletException {

        // Lookup the complete User object from the database and create an Authentication for it
//        final UserDetails authenticatedUser = userDetailsService.loadUserByUsername(authentication.getName());
//        final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);
        UserAuthentication userAuthentication = (UserAuthentication) authentication;

        // Add the custom token as HTTP header to the response
        tokenAuthenticationService.addAuthentication(response, userAuthentication);

        // Add the authentication to the Security context
        //SecurityContextHolder.getContext().setAuthentication(userAuthentication);
        super.successfulAuthentication(request, response, chain, userAuthentication);
    }
}
