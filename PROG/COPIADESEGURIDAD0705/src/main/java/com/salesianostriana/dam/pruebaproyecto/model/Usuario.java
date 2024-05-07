package com.salesianostriana.dam.pruebaproyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String contrasenia;
	private int numPedidos;
	private String direccion;
	private boolean esAdmin;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Pedido> pedidos = new ArrayList<>();
}
