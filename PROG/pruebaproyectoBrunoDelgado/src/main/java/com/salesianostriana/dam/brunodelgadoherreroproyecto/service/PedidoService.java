package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;



import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Pedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.PedidoRepositorio;

@Service
public class PedidoService extends BaseServiceImpl<Pedido, Long, PedidoRepositorio> {
	


	public boolean existeVentaSinFinalizar(Usuario usuario) {
		return this.repository.existsById(null);
	}
	

	public double calcularPrecio(Pedido pedido) {
		
		
		
		return pedido.getLineasDePedido().stream().mapToDouble(ldp -> ldp.getSubtotal()).sum();
	}
	
public void limpiarCarrito(Pedido p) {
	p.getLineasDePedido().clear();
}
}


