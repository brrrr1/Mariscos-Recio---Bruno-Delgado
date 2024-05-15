/**
 * 
 */
package com.salesianostriana.dam.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase que modela UN Curso que tiene MUCHOS alumnos
 * Ojo: Las OneToMany "solas o unidireccionales" no son eficientes y solo sería adecuada 
 * cuando esos "muchos" son pocas cosas, un nombre mejor 
 * para la unidireccional sería OneToFew (uno a pocos), 
 * por lo que nosotros haremos las bidireccionales, es decir, 
 * OneToMany + ManyToOne en el otro lado, en este caso, ManyToOne en Alumno
 * @author Luismi
 */
@Data @NoArgsConstructor
@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String tutor;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="curso")
	private List<Alumno> alumnos = new ArrayList<>();
	
	/**
	 * @param nombre
	 * @param tutor
	 */
	public Curso(String nombre, String tutor) {
		this.nombre = nombre;
		this.tutor = tutor;
	}
	
	/**
	 * @param nombre
	 * @param tutor
	 */
	public Curso(String nombre) {
		this.nombre = nombre;
	}	
	/********************************************/
	/* MÉTODOS AUXILIARES					    */
	/********************************************/
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un alumno
	 * a la colección de alumnos de un curso, y asigna a dicho alumno este curso como el suyo.
	 * @param a
	 */
	public void addAlumno(Alumno a) {
		this.alumnos.add(a);
		a.setCurso(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un alumno
	 * de la colección de alumnos de un curso, y desasigna a dicho alumno el curso, dejándolo como nulo.
	 * @param a
	 */
	public void removeAlumno(Alumno a) {
		this.alumnos.remove(a);
		a.setCurso(null);
	}
}
