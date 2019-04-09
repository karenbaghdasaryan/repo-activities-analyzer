package com.webbfontaine.repoactivitiesanalyzer.core.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationDetailsConverter {
    Object convertAuthenticationDetails(Authentication authentication);
}
