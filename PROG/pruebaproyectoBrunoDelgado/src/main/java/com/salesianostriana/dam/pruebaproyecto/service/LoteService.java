package com.salesianostriana.dam.pruebaproyecto.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.Lote;
import com.salesianostriana.dam.pruebaproyecto.repositorios.LoteRepositorio;

@Service
public class LoteService extends BaseServiceImpl<Lote, Long, LoteRepositorio> {

	public List<Lote> ordenarAlfabeticoAZ(){
		return this.repository.ordenarAlfabeticoAZ();
	}
	
	
	public List<Lote> ordenarAlfabeticoZA(){
		return this.repository.ordenarAlfabeticoZA();
	}
	
	
	public List<Lote> ordenarLikesMayor(){
		return this.repository.ordenarLikesMayor();
	}
	
	
	public List<Lote> ordenarLikesMenor(){
	return this.repository.ordenarLikesMenor();
	}
	
	public List<Lote> ordenarDescMayor(){
		return this.repository.ordernarDescuentoMayor();
	}
	
	public List<Lote> ordenarDescMenor(){
		return this.repository.ordernarDescuentoMenor();
	}
	
	public List<Lote> ordenarPrecioMayor(){
		return this.repository.ordernarPrecioMayor();
	}
	
	public List<Lote> ordenarPrecioMenor(){
		return this.repository.ordernarPrecioMenor();
	}
	
	public List<Lote> buscarPorNombre(String busqueda) {
		List<Lote> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
}
