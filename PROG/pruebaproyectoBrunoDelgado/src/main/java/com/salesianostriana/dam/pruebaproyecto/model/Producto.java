package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String descripcion;
	private int likes;
	private String foto;
	private double precio;

	public void addLineaDePedido(LineaDePedido ldp) {
		ldp.setPedido(this);
		this.LineasDePedido.add(ldp);
	}

	public void removeLineaDePedido(LineaDePedido ldp) {
		this.LineasDePedido.remove(ldp);
		ldp.setPedido(null);

	}

}
