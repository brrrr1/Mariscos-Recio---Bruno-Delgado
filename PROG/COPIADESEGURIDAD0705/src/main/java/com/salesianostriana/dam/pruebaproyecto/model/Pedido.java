
package com.salesianostriana.dam.pruebaproyecto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private long id;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaPedido;

	private String contenido;
	private double precio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id") // nombre de la columna en la tabla Pedido que referencia a Usuario
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empleado_id") // nombre de la columna en la tabla Pedido que referencia a Empleado
	private Empleado empleado;

	private EstadoPedido estado;

	/*
	 * MÉTODOS HELPER PARA LA ASOCIACIÓN CON USUARIO
	 */

	public void addToPedido(Usuario usuario) {
		this.usuario = usuario;
		usuario.getPedidos().add(this);
	}

	public void removeFromPedido(Usuario usuario) {
		usuario.getPedidos().remove(this);
		this.usuario = null;
	}
}
