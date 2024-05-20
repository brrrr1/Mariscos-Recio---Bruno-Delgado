package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.ProductoRepository;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {

	@Autowired
	private ProductoRepository repo;
	



	public List<Producto> mostrarMasFavoritos() {
		return repo.findTop9ByOrderByLikesDesc();
	}
	

	


}
