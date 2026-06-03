package pt.natixis.hello_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Olá Spring Boot";
    }

    @GetMapping("/hello/{name}")
    public String helloByName(@PathVariable String name) {
        return "Olá " + name;
    }

    @GetMapping("/hello/{name}/{surname}")
    public String helloByFullName(@PathVariable String name, @PathVariable String surname) {
        return "Olá, bom dia " + name + " " + surname;
    }



}
