package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LineaDePedido {

	@Id
	@GeneratedValue
	private long id;

	private double precio;
	private int cantidad;
	private double subtotal;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.EAGER)
	private Producto producto;

	/* MÉTODOS HELPER */

	public void addToPedido(Producto producto) {
		this.producto = producto;
		producto.getLineasDePedido().add(this);
	}

	public void removeFromPedido(Producto producto) {
		producto.getLineasDePedido().remove(this);
		this.producto = null;
	}

}
