package com.api.twiteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.twiteroo.models.TweetUser;
import com.api.twiteroo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List <TweetUser> findAll(){
        return repository.findAll();
    }

    public void create(TweetUser data){
        repository.save(data);
    }
    
}
