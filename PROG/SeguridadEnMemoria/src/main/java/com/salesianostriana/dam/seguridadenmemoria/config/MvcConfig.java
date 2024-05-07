package com.salesianostriana.dam.seguridadenmemoria.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login");
		registry.addViewController("/index");
	}

	// o

	/*
	 * @GetMapping("/inicio") public String inicio() { return "inicio"; }
	 */

}
