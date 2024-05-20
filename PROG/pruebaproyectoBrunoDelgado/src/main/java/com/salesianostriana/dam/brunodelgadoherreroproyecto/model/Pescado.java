package com.salesianostriana.dam.brunodelgadoherreroproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PESC")
public class Pescado extends ProductoPorPeso {

}
