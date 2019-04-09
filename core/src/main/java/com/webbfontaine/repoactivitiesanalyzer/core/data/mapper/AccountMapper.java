package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.AccountDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AccountMapper {
    AccountDTO accountToAccountDTO(Account account);

    List<AccountDTO> accountListToAccountDTOList(List<Account> accounts);
}
