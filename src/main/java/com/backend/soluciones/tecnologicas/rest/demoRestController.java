package com.backend.soluciones.tecnologicas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class demoRestController {


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World!";
    }

}
