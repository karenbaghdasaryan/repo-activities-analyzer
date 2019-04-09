package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.AccountDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-10T01:48:53+0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO accountToAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        accountDTO.setFirstName( account.getFirstName() );
        accountDTO.setLastName( account.getLastName() );
        accountDTO.setUsername( account.getUsername() );
        accountDTO.setEmail( account.getEmail() );
        accountDTO.setPassword( account.getPassword() );

        return accountDTO;
    }

    @Override
    public List<AccountDTO> accountListToAccountDTOList(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDTO> list = new ArrayList<AccountDTO>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( accountToAccountDTO( account ) );
        }

        return list;
    }
}
