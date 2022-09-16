package com.springclound.consumer.controller;

import com.springclound.consumer.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PortController {

    private final RestTemplate restTemplate;

    private final HttpServletRequest request;

    public PortController (RestTemplate restTemplate, HttpServletRequest request){
        this.restTemplate = restTemplate;
        this.request = request;
    }

    // 通过网关映射服务
    @PostMapping("/getToken")
    public String getToken(@RequestBody User user) {

        return "token：" + restTemplate.postForObject("http://gateway/jpa/login",user, String.class);

    }
    // 测试服务权重

    @GetMapping("/getPort")
    public String getPost() {
        String token = request.getHeader("Authorization");
        // 设置请求头,加上 Authorization
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity(null, httpHeaders);
        ResponseEntity<String> port =
                this.restTemplate.exchange("http://gateway/jpa/weightTest", HttpMethod.GET, httpEntity, String.class);
        return "Port：" + port.getBody();

    }

}