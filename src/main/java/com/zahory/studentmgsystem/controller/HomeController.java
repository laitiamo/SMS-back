package com.zahory.studentmgsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {
    @RequestMapping("/")
    public String hello() {
        return "Welcome Back!";
    }

    @RequestMapping("/test")
    public Object test() {
        return "Hello";
    }
}
