package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Pedido;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.PedidoRepositorio;

@Service
public class PedidoService extends BaseServiceImpl<Pedido, Long, PedidoRepositorio> {

	public boolean existeVentaSinFinalizar(Usuario usuario) {
		return this.repository.existsById(null);
	}

}
