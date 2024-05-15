package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Producto {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String descripcion;
	private int likes;
	private String foto;
	private double precio;

<<<<<<< HEAD
	public void addLineaDePedido(LineaDePedido ldp) {
		ldp.setPedido(this);
		this.LineasDePedido.add(ldp);
	}

	public void removeLineaDePedido(LineaDePedido ldp) {
		this.LineasDePedido.remove(ldp);
		ldp.setPedido(null);

	}
=======
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	// @Builder.Default
	@OneToMany(mappedBy = "producto", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineaDePedido> LineasDePedido = new ArrayList<>();
>>>>>>> favoritos

}
