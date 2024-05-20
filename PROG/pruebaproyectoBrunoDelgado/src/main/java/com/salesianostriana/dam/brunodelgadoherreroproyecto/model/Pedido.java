
package com.salesianostriana.dam.brunodelgadoherreroproyecto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private long id;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaPedido;

	private String contenido;
	private double precioFinal;

	private boolean finalizado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id") // nombre de la columna en la tabla Pedido que referencia a Usuario
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empleado_id") // nombre de la columna en la tabla Pedido que referencia a Empleado
	private Empleado empleado;

	private EstadoPedido estado;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineaDePedido> LineasDePedido = new ArrayList<>();

	/*
	 * MÉTODOS HELPER
	 */

	public void addPedido(Usuario usuario) {
		this.usuario = usuario;
		usuario.getPedidos().add(this);
	}

	public void removePedido(Usuario usuario) {
		usuario.getPedidos().remove(this);
		this.usuario = null;
	}

	public void addLineaDePedido(LineaDePedido ldp) {
		ldp.setPedido(this);
		this.LineasDePedido.add(ldp);
	}

	public void removeLineaDePedido(LineaDePedido ldp) {
		this.LineasDePedido.remove(ldp);
		ldp.setPedido(null);

	}
	
	public void limpiarCarrito() {
		this.getLineasDePedido().clear();
	}
}
