package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.model.Pedido;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

@Service
public class CarritoService {

	@Autowired
	PedidoService sevicioPedido;

	public Pedido getCarrito() {
		return sevicioPedido.g
	}

	/*
	 * public Pedido getCarrito(Usuario usuario) { return
	 * sevicioPedido.getCarrito(usuario); }
	 * 
	 * public void modificarCantidad(Usuario usuario, Producto producto, int
	 * cantidad) { Pedido carrito = getCarrito(usuario); }
	 */
	public void addProducto(Usuario usuario, Producto producto, int cantidad) {
	  Pedido carrito = getCarrito(usuario);
	  
	  if(! sevicioPedido.hayProductoEnCarrito(usuario, producto)) {
	  carrito.addLineaDePedido(LineaDePedido
			  .builder() 
			  .producto(producto)
	  .cantidad(cantidad) 
	  .build() ); 
	  }else { 
		  Optional <LineaDePedido> lp = buscarPorProducto(usuario, producto);
	  
	  if(lp.isPresent()) { modificarCantidad(usuario, producto,
	  lp.get().getCantidad()+1) } } servicioPedido.edit(carrito);
	  
	  }

//	public void eliminarProducto(Usuario usuario, Producto producto) {
//
//		Pedido carrito = getCarrito();
//	}
//
//	private Optional<LineaDeVenta> buscarPorProducto(Usuario usuario, Producto producto) {
//
//		Pedido carrito = getCarrito(usuario);
//	}

}
