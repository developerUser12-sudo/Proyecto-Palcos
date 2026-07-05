package com.reservapalcos.reservapalcos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservapalcos.reservapalcos.entity.Usuario;
import com.reservapalcos.reservapalcos.service.AuthService;

@Controller
public class AuthController {

    private final AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    

    @PostMapping("/registrarse")
    public String registrarse(@ModelAttribute Usuario usuario) {
        boolean registrarse = auth.registrar(usuario);
        if (registrarse) {
            return "redirect:/";
        }
        return "redirect:/registrarse?error";
    }
}
