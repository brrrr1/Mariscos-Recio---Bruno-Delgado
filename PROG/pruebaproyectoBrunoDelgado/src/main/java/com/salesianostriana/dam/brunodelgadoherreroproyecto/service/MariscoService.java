package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Marisco;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.MariscoRepository;

@Service
public class MariscoService extends BaseServiceImpl<Marisco, Long, MariscoRepository> {

	public List<Marisco> ordenarAlfabeticoAZ(){
		return this.repository.ordenarAlfabeticoAZ();
		}
		
		
		public List<Marisco> ordenarAlfabeticoZA(){
			return this.repository.ordenarAlfabeticoZA();
		}
		
		
		public List<Marisco> ordenarLikesMayor(){
			return this.repository.ordenarLikesMayor();
		}
		
		
		public List<Marisco> ordenarLikesMenor(){
		return this.repository.ordenarLikesMenor();
		}
		
		
		public List<Marisco> ordenarPrecioMayor(){
			return this.repository.ordernarPrecioMayor();
			}
		
		public List<Marisco> ordenarPrecioMenor(){
			return this.repository.ordernarPrecioMenor();
			}
		
		public List<Marisco> buscarPorNombre(String busqueda) {
			List<Marisco> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
			if (result.isEmpty()) {
				throw new ProductoNotFoundException("No hay productos con ese criterio");
			}
			return result;
		}
	
}
