package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity // quitar??
@DiscriminatorValue("L")
public class Lote extends ProductoPorUnidad {

}
