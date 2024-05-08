package com.salesianostriana.dam.seguridadenmemoria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.seguridadenmemoria.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);

}