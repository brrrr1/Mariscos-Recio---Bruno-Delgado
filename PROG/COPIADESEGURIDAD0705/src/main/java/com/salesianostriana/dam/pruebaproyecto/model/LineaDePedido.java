package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "producto_id") // nombre de la columna en la tabla Pedido
	 * que referencia a Usuario
	 */

	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON USUARIO
	 * 
	 * 
	 * public void addToPedido(Producto producto) { this.producto = producto;
	 * producto.getLineasDePedido().add(this); }
	 * 
	 * public void removeFromPedido(Producto producto) {
	 * producto.getLineasDePedido().remove(this); this.producto = null; }
	 */
}
