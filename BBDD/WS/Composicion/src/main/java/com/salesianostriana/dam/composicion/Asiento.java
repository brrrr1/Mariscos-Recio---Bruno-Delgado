package com.salesianostriana.dam.composicion;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {

	@Id
	@GeneratedValue
	private Long id;

	private int fila, columna;

	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;

	@ManyToOne
	private Avion avion;

}