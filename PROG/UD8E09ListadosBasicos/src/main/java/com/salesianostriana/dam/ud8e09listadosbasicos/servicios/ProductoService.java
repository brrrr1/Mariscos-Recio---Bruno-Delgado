package com.salesianostriana.dam.ud8e09listadosbasicos.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ud8e09listadosbasicos.modelo.Producto;
import com.salesianostriana.dam.ud8e09listadosbasicos.repositorios.ProductoRepository;
import com.salesianostriana.dam.ud8e09listadosbasicos.servicios.base.BaseServiceImpl;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {

}
