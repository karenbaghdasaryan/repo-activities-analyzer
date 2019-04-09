package com.webbfontaine.repoactivitiesanalyzer.core.service;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Bookmark;
import com.webbfontaine.repoactivitiesanalyzer.core.data.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Bookmark save(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }
}
