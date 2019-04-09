package com.webbfontaine.repoactivitiesanalyzer.core.data.mapper;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.BookmarkDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Bookmark;
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
public class BookmarkMapperImpl implements BookmarkMapper {

    @Override
    public BookmarkDTO bookmarkToBookmarkDTO(Bookmark bookmark) {
        if ( bookmark == null ) {
            return null;
        }

        BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setId( bookmark.getId() );
        bookmarkDTO.setRepoFullName( bookmark.getRepoFullName() );

        return bookmarkDTO;
    }

    @Override
    public Bookmark bookmarkDTOToBookmark(BookmarkDTO bookmarkDTO) {
        if ( bookmarkDTO == null ) {
            return null;
        }

        Bookmark bookmark = new Bookmark();

        bookmark.setId( bookmarkDTO.getId() );
        bookmark.setRepoFullName( bookmarkDTO.getRepoFullName() );

        return bookmark;
    }

    @Override
    public List<BookmarkDTO> bookmarkListToBookmarkDTOList(List<Bookmark> bookmarks) {
        if ( bookmarks == null ) {
            return null;
        }

        List<BookmarkDTO> list = new ArrayList<BookmarkDTO>( bookmarks.size() );
        for ( Bookmark bookmark : bookmarks ) {
            list.add( bookmarkToBookmarkDTO( bookmark ) );
        }

        return list;
    }
}
