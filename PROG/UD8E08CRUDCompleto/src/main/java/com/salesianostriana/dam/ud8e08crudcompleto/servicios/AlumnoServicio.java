package com.salesianostriana.dam.ud8e08crudcompleto.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ud8e08crudcompleto.modelo.Alumno;

@Service
public class AlumnoServicio {

	/*
	 * Instanciamos esta lista solo porque en el ejemplo no accedemos a la base de
	 * datos, simulamos eso
	 */
	private List<Alumno> lista;
	private long siguienteId;

	public AlumnoServicio() {
		siguienteId = 0;
		lista = new ArrayList<Alumno>();
	}

	public void agregar(Alumno a) {
		siguienteId++;
		a.setId(siguienteId);
		lista.add(a);

	}

	public List<Alumno> getLista() {
		return Collections.unmodifiableList(lista);
	}

	public Alumno findById(long id) {
		Alumno tem = null;
		boolean salir = false;

		for (int i = 0; i < lista.size() && !salir; i++) {
			if (lista.get(i).getId() == id) {
				tem = lista.get(i);
				salir = true;
			}
		}
		return tem;
	}

	public void editar(Alumno a) {

		int num;
		if (a != null) {

			Alumno tem = findById(a.getId());
			num = lista.indexOf(tem);
			lista.set(num, a);
		}

		else {

		}

	}

	public void delete(long id) {
		lista.remove(findById(id));
	}

}