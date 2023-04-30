package com.mercadona.proyecto.dao;

import org.springframework.data.repository.CrudRepository;

import com.mercadona.proyecto.domain.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
	
}

