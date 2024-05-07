package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Marisco extends ProductoPorPeso {

}
