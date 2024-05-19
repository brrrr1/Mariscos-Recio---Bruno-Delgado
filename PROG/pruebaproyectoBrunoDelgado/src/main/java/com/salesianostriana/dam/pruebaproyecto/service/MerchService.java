package com.salesianostriana.dam.pruebaproyecto.service;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.repositorios.MerchRepositorio;

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
	
	
	
}

	

