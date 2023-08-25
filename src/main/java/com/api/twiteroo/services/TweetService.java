package com.api.twiteroo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.twiteroo.models.Tweet;
import com.api.twiteroo.repository.TweetRepository;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Page<Tweet> getTweetsByPageAndUsername(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return tweetRepository.findAll(pageable);
    }


    public ResponseEntity<Page<Object[]>> getUserByUsernameWithUserDetails(String username, Pageable pageable) {
        Page<Object[]> tweetsWithUserDetailsPage = tweetRepository.findByUsernameWithUserDetails(username, pageable);
        if (!tweetsWithUserDetailsPage.isEmpty()) {
            return ResponseEntity.ok(tweetsWithUserDetailsPage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    public void create(Tweet data){
        tweetRepository.save(data);
    }
}
