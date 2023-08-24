package com.api.twiteroo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.twiteroo.models.Tweet;
import com.api.twiteroo.repository.TweetRepository;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    // public List <Tweet> findAll(){
    //     return repository.findAll();
    // }

    public List<Tweet> findAllByUsername(String page) {
        Integer quant = Integer.parseInt(page)*5;
        return repository.findAllByUsername(quant);
    }

    public void create(Tweet data){
        repository.save(data);
    }
}
