package com.salesianostriana.dam.ud8e07fechassinbd.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ud8e07fechassinbd.model.Alumno;

import lombok.NoArgsConstructor;

@Service @NoArgsConstructor
public class AlumnoServicio {

	
	public List <Alumno> lista=new ArrayList <Alumno>();
	
	public void agregar (Alumno a) {
		
		lista.add(a);
	}
		
	public List<Alumno> getLista (){
		return lista; 
	}
	
}
