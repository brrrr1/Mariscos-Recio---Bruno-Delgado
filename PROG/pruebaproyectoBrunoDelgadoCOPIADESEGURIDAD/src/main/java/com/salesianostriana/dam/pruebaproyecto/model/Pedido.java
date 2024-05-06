package com.salesianostriana.dam.pruebaproyecto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

	private long id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate FechaPedido;
	private String contenido;
	private double precio;
	private Usuario userPedido;
	private int estado;
}
