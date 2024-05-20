package com.salesianostriana.dam.brunodelgadoherreroproyecto.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class FavoritosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private long usuario_id;
	private long producto_id;

}
