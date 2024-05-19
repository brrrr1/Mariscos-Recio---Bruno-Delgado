package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;

public interface MerchRepositorio extends JpaRepository<Merch, Long> {

	
	List<Merch> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.nombre ASC
			""")
	List<Merch> ordenarAlfabeticoAZ();
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.nombre DESC
			""")
	List<Merch> ordenarAlfabeticoZA();
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.likes DESC
			""")
	List<Merch> ordenarLikesMayor();
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.likes ASC
			""")
	List<Merch> ordenarLikesMenor();
	
	@Query("""
			SELECT m FROM Merch m
			WHERE m.descuento > 0
			ORDER BY m.descuento DESC
			""")
	List<Merch> ordernarDescuentoMayor();
	
	
	@Query("""
			SELECT m FROM Merch m
			WHERE m.descuento > 0
			ORDER BY m.descuento ASC
			""")
	List<Merch> ordernarDescuentoMenor();
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.precio DESC
			""")
	List<Merch> ordernarPrecioMayor();
	
	@Query("""
			SELECT m FROM Merch m
			ORDER BY m.precio ASC
			""")
	List<Merch> ordernarPrecioMenor();

}
