package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.LineaDePedido;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.repositorios.LineaDePedidoRepositorio;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProductoRepositorio;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepositorio> {

	@Autowired
	private ProductoRepositorio repo;
	

	@Autowired
	private LineaDePedidoRepositorio ldpRepo;

	public List<Producto> mostrarMasFavoritos() {
		return repo.findTop9ByOrderByLikesDesc();
	}
	

	


}
