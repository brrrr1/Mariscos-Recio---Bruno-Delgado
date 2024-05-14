package com.salesianostriana.dam.pruebaproyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
