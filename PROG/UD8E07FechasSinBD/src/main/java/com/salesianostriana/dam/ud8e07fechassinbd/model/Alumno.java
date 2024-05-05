package com.salesianostriana.dam.ud8e07fechassinbd.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumno {
	
	/*
	 * No es necesario ningún parámetro para @GeneratedValue, 
	 * ya que por defecto es strategy=GenerationType.AUTO
	 * que es lo que se solía poner aquí
	 * */
	
	@Id	
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	
	
	//Anotamos con @DateTimeFormat de Spring para indicar el formato con el que queremos 
	//que la fecha sea recogida, en este caso, año, mes y día aunque realmente, 
	//indicamos cómo se muestra en el html, dentro de 
	//#temporals.format(alumno.fechaNacimiento, 'dd/MMM/yyyy HH:mm')
	//e incluso dependiendo del navegador y la internacionalización se mostrará de 
	//una u otra forma, pero si queremos dar luego formato hay que usar esta anotación
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	//No anotamos esta fecha, para ver cómo se puede mostrar "por defecto"
	private LocalDateTime fechaUltimoAcceso;

	public Alumno(String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	
	
}