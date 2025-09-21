package com.example.jobportal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Home {

    @GetMapping("/")
    public String home(){
        return "this new here";
    }
    @GetMapping("about")
    public String about(){
        return "hey here you found me API ABOUT";
    }
}
