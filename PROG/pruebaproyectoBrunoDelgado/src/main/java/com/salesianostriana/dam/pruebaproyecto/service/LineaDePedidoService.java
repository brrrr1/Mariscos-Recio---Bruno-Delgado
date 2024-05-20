package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.LineaDePedido;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.repositorios.LineaDePedidoRepositorio;

@Service
public class LineaDePedidoService extends BaseServiceImpl<LineaDePedido, Long, LineaDePedidoRepositorio> {

	public void anadirACarrito(LineaDePedido ldp, Producto p) {
		ldp.setProducto(p);
		this.repository.save(ldp);
	}

	public void anadirOActualizarLineaDePedido(Producto producto) {
		Optional<LineaDePedido> lineaExistente = this.repository.findByProducto(producto);
		if (lineaExistente.isPresent()) {
			LineaDePedido ldp = lineaExistente.get();
			ldp.setCantidad(ldp.getCantidad() + 1);
			ldp.getPrecioLineaDeVenta();
			this.repository.save(ldp);
		} else {
			LineaDePedido ldp = new LineaDePedido();
			ldp.setProducto(producto);
			ldp.setCantidad(1);
			ldp.getPrecioLineaDeVenta();
			this.repository.save(ldp);
		}

	}

	public Optional<LineaDePedido> buscarProductoEnLp(Long id) {
		return this.repository.buscarLp(id);
	}

	public void reducirCantidadOEliminarLineaDePedido(Producto producto) {
		Optional<LineaDePedido> lineaExistente = this.repository.findByProducto(producto);
		if (lineaExistente.isPresent()) {
			LineaDePedido ldp = lineaExistente.get();
			int nuevaCantidad = ldp.getCantidad() - 1;
			if (nuevaCantidad > 0) {
				ldp.setCantidad(nuevaCantidad);
				ldp.setSubtotal(ldp.getSubtotal()-ldp.getProducto().getPrecio());
				this.repository.save(ldp);
			}
		}
	}

}
