package com.webbfontaine.repoactivitiesanalyzer.core.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatelessAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private AuthenticationDetailsConverter detailsConverter;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(new ObjectMapper().writeValueAsString(
                detailsConverter.convertAuthenticationDetails(authentication)));
    }
}
