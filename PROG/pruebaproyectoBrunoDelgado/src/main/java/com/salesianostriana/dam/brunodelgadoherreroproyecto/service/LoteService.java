package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Lote;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.LoteRepository;

@Service
public class LoteService extends BaseServiceImpl<Lote, Long, LoteRepository> {

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
