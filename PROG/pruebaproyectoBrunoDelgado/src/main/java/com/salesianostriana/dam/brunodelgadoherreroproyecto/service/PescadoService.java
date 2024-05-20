package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Pescado;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios.PescadoRepositorio;

@Service
public class PescadoService extends BaseServiceImpl<Pescado, Long, PescadoRepositorio> {

	public List<Pescado> ordenarAlfabeticoAZ(){
		return this.repository.ordenarAlfabeticoAZ();
		}
		
		
		public List<Pescado> ordenarAlfabeticoZA(){
			return this.repository.ordenarAlfabeticoZA();
		}
		
		
		public List<Pescado> ordenarLikesMayor(){
			return this.repository.ordenarLikesMayor();
		}
		
		
		public List<Pescado> ordenarLikesMenor(){
		return this.repository.ordenarLikesMenor();
		}
		
		
		public List<Pescado> ordenarPrecioMayor(){
			return this.repository.ordernarPrecioMayor();
			}
		
		public List<Pescado> ordenarPrecioMenor(){
			return this.repository.ordernarPrecioMenor();
			}
		
		public List<Pescado> buscarPorNombre(String busqueda) {
			List<Pescado> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
			if (result.isEmpty()) {
				throw new ProductoNotFoundException("No hay productos con ese criterio");
			}
			return result;
		}
	
}
