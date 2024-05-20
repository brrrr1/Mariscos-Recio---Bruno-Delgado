package com.salesianostriana.dam.brunodelgadoherreroproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MER")
public class Merch extends ProductoPorUnidad {

}
