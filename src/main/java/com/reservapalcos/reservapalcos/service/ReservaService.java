package com.reservapalcos.reservapalcos.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.reservapalcos.reservapalcos.repository.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    

    public int calcularAnoSiguiente() {
        LocalDate hoy = LocalDate.now();
        if (hoy.getMonthValue() > 4) {
            return hoy.getYear() + 1;
        }
        return hoy.getYear();
    }
}
