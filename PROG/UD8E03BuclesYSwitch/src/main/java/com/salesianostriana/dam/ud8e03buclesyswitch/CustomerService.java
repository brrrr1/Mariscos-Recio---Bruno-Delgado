package com.salesianostriana.dam.ud8e03buclesyswitch;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

//Anotamos la clase servicio
@Service
public class CustomerService {
	
	/*
	 * De nuevo, un método que nos provee una lista de clientes
	 * simulando que vienen de la base de datosd
	 * */
	public List<Customer> getLista() {
		return Arrays.asList(
				new Customer(1, "Ángel", "Naranjo", "González", "male"),
				new Customer(2, "Luismi", "López", "Magaña", "male"),
				new Customer(3, "Novia de ", "Doraemon", "No sé", "female"),
				new Customer(4, "Corona", "Virus", "A", " ")
				);		
	}

}
