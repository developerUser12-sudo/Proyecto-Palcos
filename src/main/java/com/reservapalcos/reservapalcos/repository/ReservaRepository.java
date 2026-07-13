package com.reservapalcos.reservapalcos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservapalcos.reservapalcos.entity.Palco;
import com.reservapalcos.reservapalcos.entity.Reserva;
import com.reservapalcos.reservapalcos.enums.DiasSemana;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
   List<Reserva> findByAno(Integer ano);
   boolean existsByPalcoAndDiaAndAno(Optional<Palco> palco,DiasSemana dia,int ano);
}
