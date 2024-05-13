package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProductoRepositorio;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepositorio> {

}
