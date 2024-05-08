package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAR")
public class Marisco extends ProductoPorPeso {

}
