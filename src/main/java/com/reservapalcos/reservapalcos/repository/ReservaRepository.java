package com.reservapalcos.reservapalcos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservapalcos.reservapalcos.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
   List<Reserva> findByAno(Integer ano);

}
