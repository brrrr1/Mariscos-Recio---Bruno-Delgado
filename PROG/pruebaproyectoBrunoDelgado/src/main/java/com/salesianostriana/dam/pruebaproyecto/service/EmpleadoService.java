package com.salesianostriana.dam.pruebaproyecto.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.Empleado;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long, EmpleadoRepositorio> {

	public Usuario generarUsuario(Empleado e) {
		Usuario u = new Usuario();
		u.setNombre(e.getNombre());
		u.setUsername(e.getNombre().toLowerCase() + "mrw");
		u.setApellido(e.getApellido());
		u.setDni(e.getDni());
		u.setEmail(e.getNombre().toLowerCase() + e.getApellido().toLowerCase() + "@mariscosrecio.es");
		u.setPassword(e.getNombre().toLowerCase() + "recio" + e.getApellido().toLowerCase());
		u.setNumPedidos(0);
		u.setDireccion(null);
		u.setEsAdmin(false);
		u.setEsEmpleado(true);

		return u;
	}

	public List<Empleado> buscarPorNombre(String busqueda) {
		List<Empleado> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
	public List<Empleado> buscarPorNombreYApellido(String nombre, String apellido) {
		List<Empleado> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(nombre, apellido);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
	public Empleado buscarPorId(Long id) {
		return repository.buscarPorId(id);
	}
	
	public void darDeBaja(Empleado e) {
		e.setFechaSalida(LocalDate.now());
		
		
	}

}
