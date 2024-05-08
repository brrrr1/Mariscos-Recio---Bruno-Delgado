package com.salesianostriana.dam.pruebaproyecto.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("P")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductoPorPeso extends Producto {

	private double stock;

	public ProductoPorPeso(long id, String nombre, String descripcion, int likes, String foto, double precio,
			double stock, List<LineaDePedido> LineasDePedido) {
		super(id, nombre, descripcion, likes, foto, precio, LineasDePedido);
		this.stock = stock;
	}

}
