package com.webbfontaine.repoactivitiesanalyzer.app.security;

import com.webbfontaine.repoactivitiesanalyzer.core.data.mapper.AccountMapper;
import com.webbfontaine.repoactivitiesanalyzer.core.security.AuthenticationDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AccountAuthenticationDetailsConverter implements AuthenticationDetailsConverter {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Object convertAuthenticationDetails(Authentication authentication) {
        SecureAccount account = (SecureAccount) authentication.getPrincipal();
        return accountMapper.accountToAccountDTO(account.getAccount());
    }
}
