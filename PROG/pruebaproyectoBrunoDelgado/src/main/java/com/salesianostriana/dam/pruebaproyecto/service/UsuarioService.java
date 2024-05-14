package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

	public List<Usuario> encontrarEmpleados() {

		return encontrarEmpleados();
	}

}
