package com.api.twiteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.twiteroo.dto.UserDTO;
import com.api.twiteroo.models.TweetUser;
import com.api.twiteroo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("sign-up")

public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public List <TweetUser> getAll(){
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create (@RequestBody @Valid UserDTO req){
        service.create(new TweetUser(req));
    }

}
