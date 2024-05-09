package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Empleado;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long, EmpleadoRepositorio> {

	public Usuario generarUsuario(Empleado e) {
		Usuario u = new Usuario();
		u.setNombre(e.getNombre());
		u.setApellido(e.getApellido());
		u.setDni(null); // Asegúrate de establecer el valor correcto si es necesario
		u.setEmail(e.getNombre().toLowerCase() + e.getApellido().toLowerCase() + "@mariscosrecio.es");
		u.setContrasenia(e.getNombre().toLowerCase() + "recio" + e.getApellido().toLowerCase());
		u.setNumPedidos(0); // Asegúrate de establecer el valor correcto si es necesario
		u.setDireccion(null); // Asegúrate de establecer el valor correcto si es necesario
		u.setEsAdmin(false);
		u.setEsEmpleado(true);

		return u;
	}

	public Usuario generarUsuarioBuilder(Empleado e) {
		Usuario u = new Usuario();
		u.builder().nombre(e.getNombre()).apellido(e.getApellido()).dni(null)
				.email(e.getNombre() + e.getApellido() + "@mariscosrecio.es")
				.contrasenia(e.getNombre() + "recio" + e.getApellido()).numPedidos(0).direccion(null).esAdmin(false)
				.esEmpleado(true).build();

		return u;

	}

}
