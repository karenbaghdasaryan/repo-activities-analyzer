package com.webbfontaine.repoactivitiesanalyzer.app.security;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import com.webbfontaine.repoactivitiesanalyzer.core.security.StatelessAuthenticationSuccessHandler;
import com.webbfontaine.repoactivitiesanalyzer.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountAuthSuccessHandler extends StatelessAuthenticationSuccessHandler {

    @Autowired
    private AccountService accountService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {

        Account me = ((SecureAccount) authentication.getPrincipal()).getAccount();
        //TODO save last logged in time in account table
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
