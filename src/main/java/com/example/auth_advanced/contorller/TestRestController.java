package com.example.auth_advanced.contorller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class TestRestController {

    @GetMapping("/test")
    public String getAll(){
        return "Hello";
    }
}
