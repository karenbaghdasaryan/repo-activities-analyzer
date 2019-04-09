package com.webbfontaine.repoactivitiesanalyzer.app.security;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedAccountService {

	public Account getAuthorizedAccount() {
		SecureAccount secureAccount = (SecureAccount) SecurityContextHolder
			.getContext().getAuthentication().getPrincipal();
		return secureAccount.getAccount();
	}
}
