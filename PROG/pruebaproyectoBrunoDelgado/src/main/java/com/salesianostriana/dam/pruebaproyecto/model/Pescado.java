package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PESC")
public class Pescado extends ProductoPorPeso {

}
