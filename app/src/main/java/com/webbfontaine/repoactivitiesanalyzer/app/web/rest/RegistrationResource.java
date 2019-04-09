package com.webbfontaine.repoactivitiesanalyzer.app.web.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import com.webbfontaine.repoactivitiesanalyzer.core.data.mapper.AccountMapper;
import com.webbfontaine.repoactivitiesanalyzer.core.security.TokenHandler;
import com.webbfontaine.repoactivitiesanalyzer.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/api")
public class RegistrationResource {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Value("${jwt.token.header}")
    private String tokenName;

    @Autowired
    private TokenHandler tokenHandler;

    public RegistrationResource() {
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(
            @Valid @RequestBody AccountRegistrationRequest request,
            HttpServletResponse response
    ) {
        Account savedAccount = accountService.registerAccount(
                request.firstName,
                request.lastName,
                request.email,
                request.username,
                request.password
        );

        response.addHeader(tokenName, tokenHandler.createTokenForUser(savedAccount.getUid()));
        return ResponseEntity.ok(accountMapper.accountToAccountDTO(savedAccount));
    }

    private static class AccountRegistrationRequest {
        @Pattern(regexp = "^([A-z][A-Za-z]*\\s+[A-Za-z]*)|([A-z][A-Za-z]*)$")
        public String firstName;

        @Pattern(regexp = "^([A-z][A-Za-z]*\\s+[A-Za-z]*)|([A-z][A-Za-z]*)$")
        public String lastName;

        @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
        public String email;

        @Pattern(regexp = "^[a-zA-Z0-9]{3,}$")
        public String username;

        @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        public String password;
    }
}
