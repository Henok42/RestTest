package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {

        @RequestMapping("/world")
        public String GetHello(){
            return "Hello world";
        }
    }

