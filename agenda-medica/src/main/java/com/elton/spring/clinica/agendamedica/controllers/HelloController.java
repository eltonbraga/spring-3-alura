package com.elton.spring.clinica.agendamedica.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping
    public String helloController(){
        return "Hello Spring";
    }
}
