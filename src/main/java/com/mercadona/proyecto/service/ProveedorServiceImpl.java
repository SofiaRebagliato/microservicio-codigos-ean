package com.mercadona.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadona.proyecto.dao.ProveedorDao;
import com.mercadona.proyecto.domain.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> listaProveedores() {
		return (List<Proveedor>) proveedorDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Proveedor proveedor) {
		proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public void eliminar(Proveedor proveedor) {
		proveedorDao.delete(proveedor);
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor encontrarProveedor(Proveedor proveedor) {
		return proveedorDao.findById(proveedor.getIdProveedor()).orElseThrow(null);
	}

}
