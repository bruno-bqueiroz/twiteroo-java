package com.api.twiteroo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
    private TweetService service;

    // @GetMapping
    // public List<Tweet> getAll(@RequestParam String page){
    //     return service.findAllByUsername(page);
    // }


    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody @Valid TweetDTO req){
        service.create(new Tweet(req));
    }
}
