package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.EstadoPedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.LineaDePedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Pedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.LineaDePedidoRepositorio;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.PedidoRepositorio;

@Service
public class PedidoService extends BaseServiceImpl<Pedido, Long, PedidoRepositorio> {
	
	@Autowired
	private LineaDePedidoRepositorio ldpRepo;

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


