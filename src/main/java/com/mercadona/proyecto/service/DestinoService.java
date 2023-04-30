package com.mercadona.proyecto.service;

import java.util.List;

import com.mercadona.proyecto.domain.Destino;

public interface DestinoService {
	
	public List<Destino> listaDestinos();
	
	public void guardar(Destino destino);
	
	public void eliminar(Destino destino);
	
	public Destino encontrarDestino(Destino destino);
}
