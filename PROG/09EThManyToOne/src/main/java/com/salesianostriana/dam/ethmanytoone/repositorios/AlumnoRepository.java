package com.salesianostriana.dam.ethmanytoone.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ethmanytoone.modelo.Alumno;

public interface AlumnoRepository 
extends JpaRepository<Alumno, Long> {

}
