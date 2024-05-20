package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.LineaDePedido;
import com.salesianostriana.dam.pruebaproyecto.model.Marisco;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface LineaDePedidoRepositorio extends JpaRepository<LineaDePedido, Long>{
	
	 Optional<LineaDePedido> findByProducto(Producto producto);
	 
	 @Query("""
	 		SELECT lp FROM LineaDePedido lp
	 		WHERE lp.producto.id = ?1
	 		""")
	Optional <LineaDePedido> buscarLp(Long id);
	 
	 


}
