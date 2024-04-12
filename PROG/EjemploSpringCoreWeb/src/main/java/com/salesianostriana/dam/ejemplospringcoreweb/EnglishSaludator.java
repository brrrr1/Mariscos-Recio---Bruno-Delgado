package com.salesianostriana.dam.ejemplospringcoreweb;

import org.springframework.stereotype.Service;

@Service
public class EnglishSaludator implements Saludator{

	@Override
	public void imprimirSaludo() {
		System.out.println("Hello");
		
	}

	@Override
	public String saludar() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
