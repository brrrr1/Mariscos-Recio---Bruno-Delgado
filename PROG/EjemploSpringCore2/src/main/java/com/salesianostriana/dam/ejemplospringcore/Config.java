package com.salesianostriana.dam.ejemplospringcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {
	
	@Bean
	@Primary
	public Saludator spanishSaludator() {
		return new SpanishSaludator();
	}
	
	
	@Bean
	public Saludator englishSaludator() {
		return new EnglishSaludator();
	}

}
