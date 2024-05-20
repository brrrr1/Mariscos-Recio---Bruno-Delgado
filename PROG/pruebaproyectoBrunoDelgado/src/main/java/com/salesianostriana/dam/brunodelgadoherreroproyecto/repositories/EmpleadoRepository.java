package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

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
