package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.LineaDePedido;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;


public interface LineaDePedidoRepositorio extends JpaRepository<LineaDePedido, Long>{
	
	 Optional<LineaDePedido> findByProducto(Producto producto);
	 
	 @Query("""
	 		SELECT lp FROM LineaDePedido lp
	 		WHERE lp.producto.id = ?1
	 		""")
	Optional <LineaDePedido> buscarLp(Long id);
	 
	 


}
