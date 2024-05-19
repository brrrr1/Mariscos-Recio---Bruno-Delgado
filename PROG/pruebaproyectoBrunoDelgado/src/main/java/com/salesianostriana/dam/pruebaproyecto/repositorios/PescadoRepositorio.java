package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.model.Pescado;


public interface PescadoRepositorio extends JpaRepository<Pescado, Long> {

	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.nombre ASC
			""")
	List<Pescado> ordenarAlfabeticoAZ();
	
	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.nombre DESC
			""")
	List<Pescado> ordenarAlfabeticoZA();
	
	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.likes DESC
			""")
	List<Pescado> ordenarLikesMayor();
	
	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.likes ASC
			""")
	List<Pescado> ordenarLikesMenor();
	
	
	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.precio DESC
			""")
	List<Pescado> ordernarPrecioMayor();
	
	@Query("""
			SELECT p FROM Pescado p
			ORDER BY p.precio ASC
			""")
	List<Pescado> ordernarPrecioMenor();
	
	List<Pescado> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
}
