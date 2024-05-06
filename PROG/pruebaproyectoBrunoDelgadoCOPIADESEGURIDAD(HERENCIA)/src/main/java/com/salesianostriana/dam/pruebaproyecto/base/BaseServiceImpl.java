package com.salesianostriana.dam.pruebaproyecto.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

//2 funciones: Implementar la interdaz
//R es el tipo de dato del repositorio
//Con el extends obligamos al tipo generico a heredar de otro
public abstract class BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements BaseService<T, ID>{
	@Autowired
	protected R repository;
	
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	@Override
	public T save(T t) {
		return repository.save(t);
	}

	@Override
	public T edit(T t) {
		return repository.save(t);
	}

	@Override
	public void delete(T t) {
		repository.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

}
