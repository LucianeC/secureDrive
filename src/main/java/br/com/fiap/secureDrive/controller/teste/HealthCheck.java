package br.com.fiap.secureDrive.controller.teste;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class HealthCheck {
    @GetMapping
    public String getHelloWord(){
        return "HealthCheck - ok";
    }

}
