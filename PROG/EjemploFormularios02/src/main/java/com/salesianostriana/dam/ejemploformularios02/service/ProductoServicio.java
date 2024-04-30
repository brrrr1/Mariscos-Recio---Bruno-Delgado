package com.salesianostriana.dam.ejemploformularios02.service;

public class ProductoServicio {

	// Aquí habría que llamar al repositorio que haga falta y que nos haga un find
	// (findAll, findById...)
	public String[] getTipos() {
		String[] tipos = new String[] { "Lager", "Pilsen", "Guiness", "Sin filtrar" };
		return tipos;
	}
}
