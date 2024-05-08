package com.salesianostriana.dam.pruebaproyecto.base;

import java.util.List;
import java.util.Optional;

//Definimos el tipo de servicios que vamos a tener el la aplicación
//T=tipo de dato de la entidad  ID = tipo de dato del inentificador de la entidad

public interface BaseService<T, ID> {
	
	List<T> findAll();
	
	Optional<T> findById(ID id);
	
	T save(T t);
	
	T edit(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
}
