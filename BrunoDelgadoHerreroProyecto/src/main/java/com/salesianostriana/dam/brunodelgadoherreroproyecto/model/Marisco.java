package com.salesianostriana.dam.brunodelgadoherreroproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAR")
public class Marisco extends ProductoPorPeso {

}
