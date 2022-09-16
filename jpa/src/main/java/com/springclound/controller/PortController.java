package com.springclound.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PortController {


    @Value("${server.port}")
    private String port;


    @GetMapping(path = "/weightTest")
    @PreAuthorize("hasAuthority('admin')")
    public String getPort() {

        return port;
    }
}
