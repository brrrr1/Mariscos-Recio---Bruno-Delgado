package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Empleado;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorPeso;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmpleadoService servicioEmpleado;

	public List<Usuario> buscarPorNombre(String busqueda) {
		List<Usuario> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(busqueda,
				busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}

	public List<Usuario> buscarPorNombreYApellido(String nombre, String apellido) {
		List<Usuario> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(nombre,
				apellido);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}

	public boolean buscarUsername(String username) {
		return this.repository.existsByUsername(username);
	}

//	public Usuario buscarPorId(Long id) {
//		return repository.buscarPorId(id);
//	}

	public void codificarContra(Usuario usuario) {
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
	}

	public void establecerContra(Usuario u) {
		Usuario usuarioExistente = this.repository.findById(u.getId()).get();
		if (u.getPassword() == null || u.getPassword().isEmpty()) {
			u.setPassword(usuarioExistente.getPassword());
		} else {

			codificarContra(u);
		}
	}

	public void editarEmpleado(Usuario u) {
		if (u.isEsEmpleado()) {
			List<Empleado> listaIguales = servicioEmpleado.buscarPorNombreYApellido(u.getNombre(), u.getApellido());
			for (Empleado e : listaIguales) {
				e.setNombre(u.getNombre());
				e.setApellido(u.getApellido());
				e.setDni(u.getDni());
				u.setEmail(u.getNombre().toLowerCase() + "recio" + u.getApellido().toLowerCase() + "@mariscosrecio.es");
				u.setUsername(u.getNombre().toLowerCase() + "mrw");
				servicioEmpleado.edit(e);
				edit(u);
			}
		}
	}

	public String borrarUsuario(Long id) {
		Usuario u = findById(id).get();

		if (u.isEsEmpleado()) {
			List<Empleado> listaIguales = servicioEmpleado.buscarPorNombreYApellido(u.getNombre(), u.getApellido());
			for (Empleado empleado : listaIguales) {
				servicioEmpleado.delete(empleado);
			}
		}
		deleteById(id);
		return "redirect:/admin/usuarios/listaUsuarios";
	}

	public void editarUsuarioDeUnEmpleado(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());
		for (Usuario usuario : listaEmpleados) {
			usuario.setNombre(e.getNombre());
			usuario.setApellido(e.getApellido());
			usuario.setUsername(e.getNombre().toLowerCase() + "mrw");
			usuario.setDni(e.getDni());
			usuario.setEmail(e.getNombre().toLowerCase() + e.getApellido().toLowerCase() + "@mariscosrecio.es");
			usuario.setPassword(e.getNombre().toLowerCase() + "recio" + e.getApellido().toLowerCase());
			usuario.setNumPedidos(0);
			usuario.setDireccion(null);
			usuario.setEsAdmin(false);
			usuario.setEsEmpleado(true);
			edit(usuario);
		}
	}

	public void borrarUsuariosDeUnEmpleado(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());

		for (Usuario usuario : listaEmpleados) {
			delete(usuario);
		}
	}
	
	public void cambiarUsuarioTrasBaja(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());
		for (Usuario u : listaEmpleados) {
			u.setEsEmpleado(false);
			
			servicioEmpleado.edit(e);
			
			edit(u);
		}
	}

}
