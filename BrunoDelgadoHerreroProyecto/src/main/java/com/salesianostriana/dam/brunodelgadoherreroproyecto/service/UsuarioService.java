package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Empleado;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmpleadoService servicioEmpleado;

	//Método para la barra de búsqueda, devuelve lista de todo lo que encuentre con una palabra
	public List<Usuario> buscarPorNombre(String busqueda) {
		List<Usuario> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(busqueda,
				busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	//Método para la barra de búsqueda, devuelve lista de todo lo que encuentre con el nombre y el apellido
	public List<Usuario> buscarPorNombreYApellido(String nombre, String apellido) {
		List<Usuario> result = this.repository.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(nombre,
				apellido);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}

	//Boleano que devuelve true si en la base de datos ya existe el nombre que le pasamos
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

	//Para evitar algunos petes de id cannot be null uso este metodo que le vuelve a asignar su contraseña si se la encuentra como null, sino solo la encripta
	public void establecerContra(Usuario u) {
		Usuario usuarioExistente = this.repository.findById(u.getId()).get();
		if (u.getPassword() == null || u.getPassword().isEmpty()) {
			u.setPassword(usuarioExistente.getPassword());
		} else {

			codificarContra(u);
		}
	}

	//Método que si el usuario a editar es empleado edita tambien la informacion de su empleado
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

	
	//Método que borra un usuario y si es empleado borra también su empleado
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

	
	//Método que busca el usuario de un empleado y se lo edita respecto a los cambios que se le hagan al empleado
	public void editarUsuarioDeUnEmpleado(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());
		for (Usuario usuario : listaEmpleados) {
			usuario.setNombre(e.getNombre());
			usuario.setApellido(e.getApellido());
			usuario.setUsername(e.getNombre().toLowerCase() + "mrw");
			usuario.setDni(e.getDni());
			usuario.setEmail(e.getNombre().toLowerCase() + e.getApellido().toLowerCase() + "@mariscosrecio.es");
//			usuario.setPassword(e.getNombre().toLowerCase() + "recio" + e.getApellido().toLowerCase());
			usuario.setNumPedidos(0);
			usuario.setDireccion(null);
			usuario.setEsAdmin(false);
			usuario.setEsEmpleado(true);
			edit(usuario);
		}
	}

	
	//Método que cuando borras un empleado también borra su usuario
	public void borrarUsuariosDeUnEmpleado(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());

		for (Usuario usuario : listaEmpleados) {
			delete(usuario);
		}
	}
	
	
	//Método que cambia la información del usuario de un empleado cuando se le da de baja
	public void cambiarUsuarioTrasBaja(Empleado e) {
		List<Usuario> listaEmpleados = buscarPorNombreYApellido(e.getNombre(), e.getApellido());
		for (Usuario u : listaEmpleados) {
			u.setEsEmpleado(false);
			
			servicioEmpleado.edit(e);
			
			edit(u);
		}
	}
	
	//Método que comprueba sin un username existe en la bd.
	public boolean usernameExists(Usuario usuario) {
		if (buscarUsername(usuario.getUsername())) {
			return true;
		}else {
			return false;
		}
	}
	
	//Método que comprueba si el username que se introduce en el usuario es igual que el username del usuario que está usando la aplicación
	public boolean comprobarNombreDeUsuario(Usuario usuarioFormulario, Usuario usuarioLogged) {
		if(usuarioFormulario.getUsername().equals(usuarioLogged.getUsername())) {
			return true;
		}else {
			return false;
		}
	}

}
