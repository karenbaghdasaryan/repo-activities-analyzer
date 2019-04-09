package com.webbfontaine.repoactivitiesanalyzer.core.service;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import com.webbfontaine.repoactivitiesanalyzer.core.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE = "The %s should not be null";

    public Account registerAccount(String firstName, String lastName, String email, String username, String password) {
        Assert.notNull(firstName, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "firstName"));
        Assert.notNull(lastName, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "lastName"));
        Assert.notNull(email, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "email"));
        Assert.notNull(username, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "username"));
        Assert.notNull(password, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "password"));
        Account account = createAccount(firstName, lastName, email, username, password);
        return save(account);
    }

    private Account createAccount(String firstName, String lastName, String email, String username, String password) {
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        return account;
    }

    public Account save(Account account) {
        Assert.notNull(account, String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, "account"));
        return accountRepository.save(account);
    }
}
