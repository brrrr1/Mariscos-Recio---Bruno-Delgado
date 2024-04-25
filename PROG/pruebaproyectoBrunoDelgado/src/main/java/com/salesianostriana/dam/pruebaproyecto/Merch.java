package com.salesianostriana.dam.pruebaproyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Merch {

	private long id;
	private String nombre;
	private String descripcion;
	private int likes;
	private String foto;
	private double precio;
	
	
	public Merch(String nombre, int likes, double precio) {
		this.nombre = nombre;
		this.likes = likes;
		this.precio = precio;
	}
	
	
	
	
}

