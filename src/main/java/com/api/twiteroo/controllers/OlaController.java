package com.api.twiteroo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class OlaController {

    @GetMapping
    public String status(){
     
    return "server is listening PORT 8080";
   
    }
}
