package com.api.twiteroo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.twiteroo.dto.TweetDTO;
import com.api.twiteroo.dto.TweetWithUserDetailsDTO;
import com.api.twiteroo.models.Tweet;
import com.api.twiteroo.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")

public class TweetController {

    @Autowired
    private final TweetService tweetService;


    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }
    
    @GetMapping
    public ResponseEntity<Page<TweetWithUserDetailsDTO>> getTweetsWithUserDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<TweetWithUserDetailsDTO> tweets = tweetService.findTweetsWithUserDetails(page, size);
        return ResponseEntity.ok(tweets);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TweetWithUserDetailsDTO>> getUserByUsernameWithUserDetails(@PathVariable String username) {
        List<TweetWithUserDetailsDTO> tweetsWithUserDetails = tweetService.getUserByUsernameWithUserDetails(username);
        return ResponseEntity.ok(tweetsWithUserDetails);
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody @Valid TweetDTO req){
        tweetService.create(new Tweet(req));
    }
}
