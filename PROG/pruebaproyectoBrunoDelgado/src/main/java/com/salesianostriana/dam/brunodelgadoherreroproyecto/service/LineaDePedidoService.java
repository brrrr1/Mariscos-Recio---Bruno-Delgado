package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.LineaDePedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Pedido;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorUnidad;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.LineaDePedidoRepository;

@Service
public class LineaDePedidoService extends BaseServiceImpl<LineaDePedido, Long, LineaDePedidoRepository> {

	@Autowired
	private PedidoService pedidoServicio;
	
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
				ldp.setSubtotal(ldp.getSubtotal() - ldp.getProducto().getPrecio());
				this.repository.save(ldp);
			}
		}
	}

	public void borrarProductoDeLp(Long id) {
		Optional<LineaDePedido> optionalLineaDePedido = findById(id);

		if (optionalLineaDePedido.isPresent()) {
			Producto aEliminar = optionalLineaDePedido.get().getProducto();
			optionalLineaDePedido.get().removeFromProducto(aEliminar);
			edit(optionalLineaDePedido.get());
		}

	}

	public void finalizarPedido(Usuario usuario, Pedido pedido) {
		
		pedido.setLineasDePedido(findAll());
		pedido.setEstado(null);
		pedido.setUsuario(usuario);
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFinalizado(true);

		List<LineaDePedido> Lineas = pedido.getLineasDePedido();

		for (LineaDePedido ldp : Lineas) {
			Producto p = ldp.getProducto();
			int cantidad = ldp.getCantidad();

			if (p instanceof ProductoPorUnidad) {

				int nuevoStock = ((ProductoPorUnidad) p).getStock() - cantidad;
				((ProductoPorUnidad) p).setStock(nuevoStock);

			}
		}

		double precioFinalPedido = pedidoServicio.calcularPrecio(pedido);
		pedido.setPrecioFinal(precioFinalPedido);

		usuario.setNumPedidos(usuario.getNumPedidos() + 1);
		pedido.addPedido(usuario);

	}

}
