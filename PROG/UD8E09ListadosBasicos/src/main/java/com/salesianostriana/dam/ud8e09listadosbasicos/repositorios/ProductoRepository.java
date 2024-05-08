package com.salesianostriana.dam.ud8e09listadosbasicos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.ud8e09listadosbasicos.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
