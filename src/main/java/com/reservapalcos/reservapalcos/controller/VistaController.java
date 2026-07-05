package com.reservapalcos.reservapalcos.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class VistaController {

    @GetMapping("/login")
    public String vistaLogin(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()
            && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "login";
    }
    @GetMapping("/registrarse")
    public String vistaRegistro() {
        return "registrarse";
    }
    @GetMapping("/")
    public String vistaIndex() {
        return "index";
    }
}
