package com.cred.chatApp.controller;

import com.cred.chatApp.dto.SearchResponse;
import com.cred.chatApp.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/global")
    public ResponseEntity<SearchResponse> globalSearch(@RequestParam String keyword) {
        SearchResponse response = searchService.globalSearch(keyword);
        if (response.getMessages().isEmpty() && response.getUsers().isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(response);
    }
}
