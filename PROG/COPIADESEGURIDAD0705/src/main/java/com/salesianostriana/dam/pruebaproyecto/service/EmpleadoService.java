package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Empleado;
import com.salesianostriana.dam.pruebaproyecto.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoService extends BaseServiceImpl<Empleado, Long, EmpleadoRepositorio> {

}
