package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Lote;


public interface LoteRepository extends JpaRepository<Lote, Long> {

	List<Lote> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.nombre ASC
			""")
	List<Lote> ordenarAlfabeticoAZ();

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.nombre DESC
			""")
	List<Lote> ordenarAlfabeticoZA();

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.likes DESC
			""")
	List<Lote> ordenarLikesMayor();

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.likes ASC
			""")
	List<Lote> ordenarLikesMenor();

	@Query("""
			SELECT l FROM Lote l
			WHERE l.descuento > 0
			ORDER BY l.descuento DESC
			""")
	List<Lote> ordernarDescuentoMayor();

	@Query("""
			SELECT l FROM Lote l
			WHERE l.descuento > 0
			ORDER BY l.descuento ASC
			""")
	List<Lote> ordernarDescuentoMenor();

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.precio DESC
			""")
	List<Lote> ordernarPrecioMayor();

	@Query("""
			SELECT l FROM Lote l
			ORDER BY l.precio ASC
			""")
	List<Lote> ordernarPrecioMenor();
}
