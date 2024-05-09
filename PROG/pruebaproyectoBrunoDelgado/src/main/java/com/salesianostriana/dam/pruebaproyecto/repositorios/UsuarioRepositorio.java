package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);

}
