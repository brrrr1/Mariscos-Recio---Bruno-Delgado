package com.salesianostriana.dam.pruebaproyecto.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.repositorios.MerchRepositorio;


@Service
public class MerchService extends BaseServiceImpl<Merch, Long, MerchRepositorio>{
	
	@Autowired
	private MerchRepositorio repo;
	
	public void agregarBD(Merch merch) {
		repo.save(merch);
	}


}
