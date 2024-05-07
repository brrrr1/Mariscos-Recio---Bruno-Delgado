package com.salesianostriana.dam.pruebaproyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
@Builder
@MappedSuperclass
public class Producto {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String descripcion;
	private int likes;
	private String foto;
	private double precio;

	@OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<LineaDePedido> LineasDePedido = new ArrayList<>();

}
