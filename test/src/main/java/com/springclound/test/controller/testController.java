package com.springclound.test.controller;

import com.springclound.test.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class testController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/getToken")
    public String index(User user) {

        return "token：" + this.restTemplate.getForObject("http://Localhost:8020/jpa/login", String.class, user);

    }

}