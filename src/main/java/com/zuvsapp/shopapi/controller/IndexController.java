package com.zuvsapp.shopapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping(path="/hello")
    public String hellWorld() {
        return "Hello World!";
    }
}