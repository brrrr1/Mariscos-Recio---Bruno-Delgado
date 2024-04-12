package com.salesianostriana.dam.ejemplospringcore;

import org.springframework.stereotype.Service;

@Service
public class EnglishSaludator implements Saludator{

	@Override
	public void imprimirSaludo() {
		System.out.println("Hello");
		
	}

}
