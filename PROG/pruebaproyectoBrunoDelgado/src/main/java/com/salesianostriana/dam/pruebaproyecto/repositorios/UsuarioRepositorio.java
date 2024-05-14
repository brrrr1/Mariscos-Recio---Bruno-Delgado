package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);

	@Query("""
			SELECT u FROM Usuario u
			WHERE u.username = 'admin'
			""")
	public List<Usuario> encontrarAdmin();

	@Query("""
			SELECT u FROM Usuario u
			WHERE u.esEmpleado = true
			""")
	public List<Usuario> encontrarEmpleados();

}
