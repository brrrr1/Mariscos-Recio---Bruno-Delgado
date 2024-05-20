package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.LineaDePedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.LineaDePedidoRepositorio;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.ProductoRepositorio;

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
