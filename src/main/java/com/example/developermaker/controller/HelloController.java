package com.example.developermaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(name = "name", required = false)String name){
        return name == null? "Hello world": "Hello "+ name;
    }
    @PostMapping("/arrayTest")
    public String toStringFromArray(
            @RequestBody List<String> stringList
    ){
        return stringList.stream().collect(Collectors.joining(","));
    }
}
