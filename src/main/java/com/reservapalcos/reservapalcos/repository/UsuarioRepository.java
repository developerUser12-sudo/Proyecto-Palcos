package com.reservapalcos.reservapalcos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservapalcos.reservapalcos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
