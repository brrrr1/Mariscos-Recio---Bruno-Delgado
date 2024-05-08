package com.salesianostriana.dam.pruebaproyecto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Empleado {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String apellido;
	private double sueldo;
	private String foto;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaIngreso;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaSalida;

	@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Pedido> pedidosGestionados = new ArrayList<>();

}
