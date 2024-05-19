package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String descripcion;
    private int likes;
    private String foto;
    private double precio;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<LineaDePedido> lineasDePedido = new ArrayList<>();
}
