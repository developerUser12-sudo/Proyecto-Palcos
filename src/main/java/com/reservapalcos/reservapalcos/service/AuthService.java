package com.reservapalcos.reservapalcos.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reservapalcos.reservapalcos.entity.Usuario;
import com.reservapalcos.reservapalcos.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public AuthService(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public boolean login(String email, String password) {
        Optional<Usuario> usuario = repo.findByEmail(email);
        if (usuario.isPresent()) {
            return encoder.matches(password, usuario.get().getContrasena());   
        }
        return false;
    }
    public boolean registrar(Usuario usuario) {

        if (repo.findByEmail(usuario.getEmail()).isPresent()) {
            return false;
        }
        usuario.setContrasena(encoder.encode(usuario.getContrasena()));
        repo.save(usuario);
        return true;

    }

}
