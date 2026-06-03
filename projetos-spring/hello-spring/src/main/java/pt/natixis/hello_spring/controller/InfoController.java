package pt.natixis.hello_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @GetMapping("/app")
    public String appInfo(){
        return "Aplicação Java Spring Boot - Natixis Dev Stream 2026";
    }

    @GetMapping("/autor")
    public String autorInfo(){
        return "Aplicação Java Spring Boot - Desenvolvida por Vitor Santos";
    }

}
