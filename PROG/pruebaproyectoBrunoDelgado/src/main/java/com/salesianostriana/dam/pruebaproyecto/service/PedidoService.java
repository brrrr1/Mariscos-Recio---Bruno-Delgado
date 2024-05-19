package com.salesianostriana.dam.pruebaproyecto.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.EstadoPedido;
import com.salesianostriana.dam.pruebaproyecto.model.LineaDePedido;
import com.salesianostriana.dam.pruebaproyecto.model.Pedido;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.LineaDePedidoRepositorio;
import com.salesianostriana.dam.pruebaproyecto.repositorios.PedidoRepositorio;

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
}


