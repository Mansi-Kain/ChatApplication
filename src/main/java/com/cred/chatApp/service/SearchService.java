package com.cred.chatApp.service;

import com.cred.chatApp.dto.SearchResponse;

public interface SearchService {
    SearchResponse globalSearch(String keyword);
}
