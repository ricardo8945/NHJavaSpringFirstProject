package pe.scotiabank.serviciows.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PruebaController {

    @GetMapping("/servicio")
    public String retrieveObject(){
        return "Primer Servicio";
    }

}
