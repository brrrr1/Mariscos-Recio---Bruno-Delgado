package com.salesianostriana.dam.ud8e09listadosbasicos.modelo;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Puntuacion {

	@Id
	@GeneratedValue
	private Long id;
	
	//Ya hemos visto mejores formas
	//de trabajar con fechas, esto solo es para el ejemplo
	
	@CreatedDate
	private Date fecha;
	
	private int puntuacion;
	
	@ManyToOne
	private Producto producto;

	public Puntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public Puntuacion(int puntuacion, Producto producto) {
		this.puntuacion = puntuacion;
		this.producto = producto;
	}
	
}