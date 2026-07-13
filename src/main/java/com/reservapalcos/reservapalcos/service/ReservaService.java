package com.reservapalcos.reservapalcos.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.reservapalcos.reservapalcos.entity.Palco;
import com.reservapalcos.reservapalcos.entity.Reserva;
import com.reservapalcos.reservapalcos.entity.Usuario;
import com.reservapalcos.reservapalcos.enums.DiasSemana;
import com.reservapalcos.reservapalcos.repository.PalcoRepository;
import com.reservapalcos.reservapalcos.repository.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PalcoRepository palcoRepository;

    public ReservaService(ReservaRepository reservaRepository, PalcoRepository palcoRepository) {
        this.reservaRepository = reservaRepository;
        this.palcoRepository = palcoRepository;
    }

    public boolean registrarReserva(Usuario usuario, Map<String, List<Long>> reservas) {
        for (Map.Entry<String, List<Long>> entry : reservas.entrySet()) {

            DiasSemana dia = DiasSemana.valueOf(entry.getKey());

            for (Long palcoId : entry.getValue()) {
                if (reservaRepository.existsByPalcoAndDiaAndAno(palcoRepository.findById(palcoId), dia, this.calcularAnoSiguiente())) {
                    return false;
                }
            }

        }
        for (Map.Entry<String, List<Long>> entry : reservas.entrySet()) {

            DiasSemana dia = DiasSemana.valueOf(entry.getKey());

            for (Long palcoId : entry.getValue()) {
                Reserva reserva = new Reserva();
                Palco palco = palcoRepository.findById(palcoId).orElseThrow(() -> new RuntimeException("Palco no encontrado"));;
                reserva.setAno(this.calcularAnoSiguiente());
                reserva.setDia(dia);
                reserva.setPalco(palco);
                reserva.setUsuario(usuario);
                switch (dia) {
                    case DOMINGORAMOS -> reserva.setPrecio(new BigDecimal(20));
                    case LUNES -> reserva.setPrecio(new BigDecimal(10));
                    case MARTES -> reserva.setPrecio(new BigDecimal(10));
                    case MIERCOLES -> reserva.setPrecio(new BigDecimal(10));
                    case JUEVES -> reserva.setPrecio(new BigDecimal(20));
                    case VIERNES -> reserva.setPrecio(new BigDecimal(10));
                    case SABADO -> reserva.setPrecio(new BigDecimal(10));
                }
                reservaRepository.save(reserva);
            }

        }

        return true;
    }

    public Integer calcularAnoSiguiente() {
        LocalDate hoy = LocalDate.now();
        if (hoy.getMonthValue() > 4) {
            return hoy.getYear() + 1;
        }
        return hoy.getYear();
    }
}
