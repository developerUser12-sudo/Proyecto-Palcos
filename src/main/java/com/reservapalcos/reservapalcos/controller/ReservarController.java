package com.reservapalcos.reservapalcos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reservapalcos.reservapalcos.entity.Usuario;
import com.reservapalcos.reservapalcos.service.ReservaService;

@Controller
public class ReservarController {

    private final ReservaService reservaService;

    public ReservarController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @PostMapping("/reservar")
    @ResponseBody
    public ResponseEntity<String> reservar(@AuthenticationPrincipal Usuario usuario,@RequestBody Map<String, List<Long>> reservas){
        boolean request=reservaService.registrarReserva(usuario, reservas);
        if (request) {
            return ResponseEntity.ok().body("Reserva realizada correctamente");
        }
        return ResponseEntity.badRequest().body("Uno o varios palcos ya han sido reservados");
    }
}
