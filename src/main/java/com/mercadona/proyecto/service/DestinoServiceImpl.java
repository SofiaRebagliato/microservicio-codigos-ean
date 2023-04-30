package com.mercadona.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadona.proyecto.dao.DestinoDao;
import com.mercadona.proyecto.domain.Destino;

@Service
public class DestinoServiceImpl implements DestinoService{

	@Autowired
	private DestinoDao destinoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Destino> listaDestinos() {
		return (List<Destino>) destinoDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Destino destino) {
		destinoDao.save(destino);
	}

	@Override
	@Transactional
	public void eliminar(Destino destino) {
		destinoDao.delete(destino);
	}

	@Override
	@Transactional(readOnly = true)
	public Destino encontrarDestino(Destino destino) {
		return destinoDao.findById(destino.getIdDestino()).orElseThrow(null);
	}

}
