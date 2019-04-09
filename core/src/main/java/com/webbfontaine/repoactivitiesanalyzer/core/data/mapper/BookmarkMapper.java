package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.BookmarkDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Bookmark;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookmarkMapper {
    BookmarkDTO bookmarkToBookmarkDTO(Bookmark bookmark);

    Bookmark bookmarkDTOToBookmark(BookmarkDTO bookmarkDTO);

    List<BookmarkDTO> bookmarkListToBookmarkDTOList(List<Bookmark> bookmarks);
}
