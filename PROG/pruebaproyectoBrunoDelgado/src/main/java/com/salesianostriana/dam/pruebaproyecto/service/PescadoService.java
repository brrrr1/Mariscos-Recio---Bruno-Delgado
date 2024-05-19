package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Pescado;
import com.salesianostriana.dam.pruebaproyecto.model.Pescado;
import com.salesianostriana.dam.pruebaproyecto.repositorios.PescadoRepositorio;

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
	
}
