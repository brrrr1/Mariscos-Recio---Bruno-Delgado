package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.repositorios.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepositorio repo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return repo.findFirstByName(name)
				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}

}
