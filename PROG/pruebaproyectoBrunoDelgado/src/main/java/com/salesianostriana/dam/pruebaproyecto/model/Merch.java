package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MER")
public class Merch extends ProductoPorUnidad {

}
