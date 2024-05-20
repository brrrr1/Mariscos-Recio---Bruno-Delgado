package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LineaDePedido {

    @Id
    @GeneratedValue
    private long id;

    private double precio;
    private int cantidad;
    private double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;

    public void getPrecioLineaDeVenta() {
        setSubtotal(producto.getPrecio() * cantidad);
    }

    /* MÉTODOS HELPER */
    public void addToProducto(Producto producto) {
        this.producto = producto;
        producto.getLineasDePedido().add(this);
    }

    public void removeFromProducto(Producto producto) {
        producto.getLineasDePedido().remove(this);
        this.producto = null;
    }
    

    
    
    
    
}
