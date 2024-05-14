package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepositorio> {

}
