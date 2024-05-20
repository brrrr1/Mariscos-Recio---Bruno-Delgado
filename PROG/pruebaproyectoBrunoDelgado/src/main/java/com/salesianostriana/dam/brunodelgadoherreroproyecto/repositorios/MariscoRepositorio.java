package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Marisco;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Pescado;


public interface MariscoRepositorio extends JpaRepository<Marisco, Long> {
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.nombre ASC
			""")
	List<Marisco> ordenarAlfabeticoAZ();
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.nombre DESC
			""")
	List<Marisco> ordenarAlfabeticoZA();
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.likes DESC
			""")
	List<Marisco> ordenarLikesMayor();
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.likes ASC
			""")
	List<Marisco> ordenarLikesMenor();
	
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.precio DESC
			""")
	List<Marisco> ordernarPrecioMayor();
	
	@Query("""
			SELECT m FROM Marisco m
			ORDER BY m.precio ASC
			""")
	List<Marisco> ordernarPrecioMenor();
	
	List<Marisco> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);

}
