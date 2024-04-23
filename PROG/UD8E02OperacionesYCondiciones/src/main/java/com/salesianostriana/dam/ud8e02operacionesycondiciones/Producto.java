package com.salesianostriana.dam.ud8e02operacionesycondiciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Anotamos la clase con las anotaciones de Lombok. Estas son:
 * @Data para los getters, setters, ToString y otros de los atributos
 * @AllArgsConstructor para el constructor con todos los argumentos
 * @NoArgsConstructor para el constructor sin argumentos
 * 
 * Esto hace que no tengamos que escribirlos en la clase. Podemos ver que existen
 * en la ventana Outline de la derecha
 * */
@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {
	
	private String nombre;
	private String descripcion;
	private float precio;
	private int numeroVotos;
	private float porcentajeSatisfaccion;
	
	/*
	 * Si vamos a usar un constructor diferente al que tiene todos o ningún arguemento
	 * hay que escribirlo en la clase, por ejemplo, este de debajo con solo 3 argumentos
	 * */
	public Producto (String nombre, String descripcion, float precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
}