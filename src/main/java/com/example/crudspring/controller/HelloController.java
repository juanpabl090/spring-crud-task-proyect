package com.example.crudspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("api/greeting")
    public String saludo() {
        return "Hello World";
    }

}

