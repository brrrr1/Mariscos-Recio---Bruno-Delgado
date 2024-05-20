package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;





import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Merch;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.MerchRepositorio;

@Service
public class MerchService extends BaseServiceImpl<Merch, Long, MerchRepositorio> {
	
	

	public List<Merch> ordenarAlfabeticoAZ(){
	return this.repository.ordenarAlfabeticoAZ();
	}
	
	
	public List<Merch> ordenarAlfabeticoZA(){
		return this.repository.ordenarAlfabeticoZA();
	}
	
	
	public List<Merch> ordenarLikesMayor(){
		return this.repository.ordenarLikesMayor();
	}
	
	
	public List<Merch> ordenarLikesMenor(){
	return this.repository.ordenarLikesMenor();
	}
	
	public List<Merch> ordenarDescMayor(){
		return this.repository.ordernarDescuentoMayor();
		}
	
	public List<Merch> ordenarDescMenor(){
		return this.repository.ordernarDescuentoMenor();
		}
	
	public List<Merch> ordenarPrecioMayor(){
		return this.repository.ordernarPrecioMayor();
		}
	
	public List<Merch> ordenarPrecioMenor(){
		return this.repository.ordernarPrecioMenor();
		}
	
	public List<Merch> buscarPorNombre(String busqueda) {
		List<Merch> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
}

	

