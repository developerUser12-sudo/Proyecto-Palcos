package com.reservapalcos.reservapalcos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class VistaController {

    @GetMapping("/login")
    public String vistaLogin() {
        return "login";
    }
    @GetMapping("/registrarse")
    public String vistaRegistro() {
        return "registrarse";
    }
}
