package com.salesianostriana.dam.seguridadenmemoria.component;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.seguridadenmemoria.model.Usuario;
import com.salesianostriana.dam.seguridadenmemoria.repositories.UsuarioRepositorio;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final UsuarioRepositorio repo;
	private final PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {

		Usuario usuario = Usuario.builder().admin(false).username("user")
				// .password("1234")
				.password(passwordEncoder.encode("1234")).build();

		Usuario admin = Usuario.builder().admin(true).username("admin").password(passwordEncoder.encode("admin"))
				.build();

		repo.saveAll(List.of(usuario, admin));

	}

}
