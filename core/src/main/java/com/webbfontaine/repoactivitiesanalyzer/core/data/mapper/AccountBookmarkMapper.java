package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.AccountBookmarkDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.AccountBookmark;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {AccountMapper.class, BookmarkMapper.class}
)
public interface AccountBookmarkMapper {
    AccountBookmark accountBookmarkDTOToAccountBookmark(AccountBookmarkDTO accountBookmarkDTO);

    AccountBookmarkDTO accountBookmarkToAccountBookmarkDTO(AccountBookmark accountBookmark);

    List<AccountBookmarkDTO> accountBookmarkListToAccountBookmarkDTOList(List<AccountBookmark> accountBookmark);
}
