package com.springclound.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/test/one")
    public String testOne() {

        return "限流测试：接口1";
    }

    @GetMapping(path = "/test/two")
    public String testTwo() {

        return "限流测试：接口2";
    }
}
