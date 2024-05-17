package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorPeso;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

	public List<Usuario> buscarPorNombre(String busqueda) {
		List<Usuario> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
	
	public boolean buscarUsername(String username) {
		return this.repository.existsByUsername(username);
	}
	
}
