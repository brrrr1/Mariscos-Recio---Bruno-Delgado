package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.Empleado;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

	@Query("""
			SELECT e FROM Empleado e
			""")
	public List<Empleado> listarEmpleados();

	@Query("""
			SELECT e FROM Empleado e
			WHERE e.id = ?1
			""")
	public Empleado buscarPorId(long id);
	
	List<Empleado> findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCase(String nombre, String descripcion);
	
	
	@Query("""
			SELECT e FROM Empleado e
			WHERE e.id = ?1
			""")
	public Empleado buscarPorId(Long id);
		
	

}
