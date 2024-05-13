package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Favoritos {

	@EmbeddedId
	private FavoritosPK favoritosPK = new FavoritosPK();

	public Favoritos(Usuario u, Producto p) {
		this.usuario = u;
		this.producto = p;
	}

	@ManyToOne
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@MapsId("producto_id")
	@JoinColumn(name = "producto_id")
	private Producto producto;

	/*
	 * MÉTODOS HELPER
	 */

	public void addToUsuario(Usuario u) {
		u.getFavoritos().add(this);
		this.usuario = u;
	}

	public void removeFromAlumno(Usuario u) {
		u.getFavoritos().remove(this);
		this.usuario = null;
	}

}
