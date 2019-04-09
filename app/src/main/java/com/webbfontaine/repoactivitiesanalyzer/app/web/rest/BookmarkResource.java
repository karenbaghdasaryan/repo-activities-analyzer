package com.webbfontaine.repoactivitiesanalyzer.app.web.rest;

import com.webbfontaine.repoactivitiesanalyzer.core.data.dto.BookmarkDTO;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Bookmark;
import com.webbfontaine.repoactivitiesanalyzer.core.data.mapper.BookmarkMapper;
import com.webbfontaine.repoactivitiesanalyzer.core.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkResource {

    @Autowired
    private BookmarkMapper bookmarkMapper;

    @Autowired
    private BookmarkService bookmarkService;

    public BookmarkResource() {
    }

    @PostMapping
    public ResponseEntity create(
            @Valid @RequestBody BookmarkDTO bookmarkDTO) {
        Bookmark bookmark = bookmarkMapper.bookmarkDTOToBookmark(bookmarkDTO);
        bookmarkService.save(bookmark);
        return ResponseEntity.ok(bookmark);
    }
}
