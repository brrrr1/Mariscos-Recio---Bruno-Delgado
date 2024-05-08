package com.salesianostriana.dam.ud8e09listadosbasicos.modelo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {

	
	@Id
	@GeneratedValue
	private Long id;	
	private String nombre;
	
	/*JPA nos permite mediante la anotación @Lob mapear 
	 * con la base de datos objetos pesados, como podría ser imágenes, 
	 * xml, binarios, cadenas de texto extensas, json, etc. 
	 * Cualquier objeto que pueda tener un tamaña muy grande 
	 * o de longitud indefinida.
	 * En nuestro ejemplo no sirve de nada pero 
	 * ya que está la hemos dejado para decir qué es*/
	
	
	@Lob 
	private String descripcion;	
	private float pvp;
	private float descuento;
	
	//Trabajaremos las imágenes como un String 
	private String imagen;
	
	@ManyToOne
	private Categoria categoria;
		
	//Excluimos Equals, hashcode y toString de Lombok para evitar 
	//problemas con la asociación	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="producto", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private Set<Puntuacion> puntuaciones = new HashSet<Puntuacion>();
	
	public Producto(String nombre, String descripcion, float pvp, float descuento, String imagen, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.descuento = descuento;
		this.imagen = imagen;
		this.categoria = categoria;
	}
	
	/**
	 * Métodos helper, aunque en este ejemplo no se usan, 
	 * los veremos más adelante, están relacionados con las 
	 * asociaciones
	 */
	public void addPuntuacion(Puntuacion puntuacion) {
		this.puntuaciones.add(puntuacion);
		puntuacion.setProducto(this);
	}
	
	
	public double getPuntuacionMedia() {
		if (this.puntuaciones.isEmpty())
			return 0;
		else 
			return this.puntuaciones.stream()
					.mapToInt(Puntuacion::getPuntuacion)
					.average()
					.getAsDouble();
	}
	
	public double getNumeroTotalPuntuaciones() {
		return this.puntuaciones.size();
	}
}
