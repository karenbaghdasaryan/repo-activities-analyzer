package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.AccountBookmarkDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.AccountBookmark;
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
public class AccountBookmarkMapperImpl implements AccountBookmarkMapper {

    @Override
    public AccountBookmark accountBookmarkDTOToAccountBookmark(AccountBookmarkDTO accountBookmarkDTO) {
        if ( accountBookmarkDTO == null ) {
            return null;
        }

        AccountBookmark accountBookmark = new AccountBookmark();

        accountBookmark.setId( accountBookmarkDTO.getId() );
        accountBookmark.setCreatedAt( accountBookmarkDTO.getCreatedAt() );
        accountBookmark.setAccount( accountBookmarkDTO.getAccount() );
        accountBookmark.setBookmark( accountBookmarkDTO.getBookmark() );

        return accountBookmark;
    }

    @Override
    public AccountBookmarkDTO accountBookmarkToAccountBookmarkDTO(AccountBookmark accountBookmark) {
        if ( accountBookmark == null ) {
            return null;
        }

        AccountBookmarkDTO accountBookmarkDTO = new AccountBookmarkDTO();

        accountBookmarkDTO.setId( accountBookmark.getId() );
        accountBookmarkDTO.setAccount( accountBookmark.getAccount() );
        accountBookmarkDTO.setBookmark( accountBookmark.getBookmark() );
        accountBookmarkDTO.setCreatedAt( accountBookmark.getCreatedAt() );

        return accountBookmarkDTO;
    }

    @Override
    public List<AccountBookmarkDTO> accountBookmarkListToAccountBookmarkDTOList(List<AccountBookmark> accountBookmark) {
        if ( accountBookmark == null ) {
            return null;
        }

        List<AccountBookmarkDTO> list = new ArrayList<AccountBookmarkDTO>( accountBookmark.size() );
        for ( AccountBookmark accountBookmark1 : accountBookmark ) {
            list.add( accountBookmarkToAccountBookmarkDTO( accountBookmark1 ) );
        }

        return list;
    }
}
