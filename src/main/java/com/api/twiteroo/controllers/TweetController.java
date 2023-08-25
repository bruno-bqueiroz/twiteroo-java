package com.api.twiteroo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.api.twiteroo.models.Tweet;
import com.api.twiteroo.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")

public class TweetController {

    @Autowired
    private final TweetService tweetService;


    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }



    @GetMapping
    public ResponseEntity<Page<Tweet>> getTweetsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
            ) {
        Page<Tweet> tweetPage = tweetService.getTweetsByPageAndUsername( page, size);
        return ResponseEntity.ok(tweetPage);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Page<Object[]>> getUserByUsernameWithUserDetails(@PathVariable String username, Pageable pageable) {
        return tweetService.getUserByUsernameWithUserDetails(username, pageable);
    }
    
    
    

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody @Valid TweetDTO req){
        tweetService.create(new Tweet(req));
    }
}
