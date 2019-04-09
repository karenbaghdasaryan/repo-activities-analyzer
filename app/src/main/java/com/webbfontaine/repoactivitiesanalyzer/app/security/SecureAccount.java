package com.webbfontaine.repoactivitiesanalyzer.app.security;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecureAccount implements UserDetails {
    private Account account;
    private Collection<GrantedAuthority> grantedAuthorities;

    public SecureAccount(Account account, Collection<GrantedAuthority> grantedAuthorities) {
        this.account = account;
        this.grantedAuthorities = grantedAuthorities;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
