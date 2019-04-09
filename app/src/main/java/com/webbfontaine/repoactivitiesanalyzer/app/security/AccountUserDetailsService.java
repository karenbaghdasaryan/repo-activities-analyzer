package com.webbfontaine.repoactivitiesanalyzer.app.security;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import com.webbfontaine.repoactivitiesanalyzer.core.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("accountUserDetailsService")
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account account = repository.findByUsername(username);

		if (account == null) {
			throw new UsernameNotFoundException("Invalid login or password");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		return new SecureAccount(account, authorities);
	}
}
