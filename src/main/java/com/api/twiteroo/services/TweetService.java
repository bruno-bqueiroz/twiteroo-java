package com.api.twiteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.twiteroo.dto.TweetWithUserDetailsDTO;
import com.api.twiteroo.models.Tweet;
import com.api.twiteroo.models.TweetUser;
import com.api.twiteroo.repository.TweetRepository;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }


    public Page<TweetWithUserDetailsDTO> findTweetsWithUserDetails(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        List<TweetWithUserDetailsDTO> tweets = tweetRepository.findAllTweetsWithUserDetails(pageable);
        return new PageImpl<>(tweets, pageable, tweets.size());
    }



 public List<TweetWithUserDetailsDTO> getUserByUsernameWithUserDetails(String username) {
        return tweetRepository.findTweetsWithUserDetailsByUsername(username);
    }

    public void create(Tweet data){
        tweetRepository.save(data);
    }
}
