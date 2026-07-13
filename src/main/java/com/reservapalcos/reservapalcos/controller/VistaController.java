package com.reservapalcos.reservapalcos.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reservapalcos.reservapalcos.enums.DiasSemana;
import com.reservapalcos.reservapalcos.repository.PalcoRepository;
import com.reservapalcos.reservapalcos.repository.ReservaRepository;
import com.reservapalcos.reservapalcos.service.ReservaService;

@Controller

public class VistaController {

    private final PalcoRepository palcoRepository;
    private final ReservaRepository reservaRepository;
    private final ReservaService reservaService;

    public VistaController(PalcoRepository palcoRepository, ReservaRepository reservaRepository,
            ReservaService reservaService) {
        this.palcoRepository = palcoRepository;
        this.reservaRepository = reservaRepository;
        this.reservaService = reservaService;
    }

    @GetMapping("/login")
    public String vistaLogin(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/registrarse")
    public String vistaRegistro(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }
        return "registrarse";
    }

    @GetMapping("/reservar")
    public String vistaReserva(Model model) {
        model.addAttribute("dias", DiasSemana.values());
        model.addAttribute("palcos", palcoRepository.findAll());
        
        model.addAttribute("reservasHechas", reservaRepository.findByAno(reservaService.calcularAnoSiguiente()));
        return "reservar";
    }

    @GetMapping("/")
    public String vistaIndex() {
        return "index";
    }
}
