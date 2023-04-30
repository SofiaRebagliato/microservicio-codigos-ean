package com.mercadona.proyecto.dao;

import org.springframework.data.repository.CrudRepository;

import com.mercadona.proyecto.domain.Proveedor;

public interface ProveedorDao extends CrudRepository<Proveedor, Integer>{
	
}

