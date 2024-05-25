package br.com.fiap.secureDrive.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWordController {
    @GetMapping
    public String getHelloWord(){
        return "Hello Word Spring Boot";
    }

}
