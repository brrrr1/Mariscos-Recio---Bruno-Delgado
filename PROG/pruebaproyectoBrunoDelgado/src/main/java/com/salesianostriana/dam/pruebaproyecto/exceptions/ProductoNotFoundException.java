package com.salesianostriana.dam.pruebaproyecto.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ProductoNotFoundException extends EntityNotFoundException{
	
	public ProductoNotFoundException() {
		super("No hay criterios con los productos de búsqueda especificados");
	}
	
	public ProductoNotFoundException(String msg) {
		super("No hay criterios con los productos de búsqueda especificados");
	}

}
