package com.salesianostriana.dam.pruebaproyecto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private double sueldo;
	private String foto;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaIngreso;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaSalida;
}
