package com.salesianostriana.dam.brunodelgadoherreroproyecto.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(ProductoNotFoundException.class)
	public ModelAndView handleProductoNotFoundException(ProductoNotFoundException ex) {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("message", ex.getMessage());
		modelView.setViewName("empty-list");
		return modelView;
	}
	
	
}
//empty-list es un html con la estructura de la pagina de productos pero sin cuerpo y con el mensaje 