package com.salesianostriana.dam.ethmanytoone.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.ethmanytoone.modelo.Curso;

public interface CursoRepository 
extends JpaRepository<Curso, Long> {

}
