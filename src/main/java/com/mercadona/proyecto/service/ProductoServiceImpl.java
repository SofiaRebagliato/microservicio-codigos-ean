package com.mercadona.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadona.proyecto.dao.ProductoDao;
import com.mercadona.proyecto.domain.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> listaProductos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	@Transactional
	public void eliminar(Producto producto) {
		productoDao.delete(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto encontrarProducto(Producto producto) {
		return productoDao.findById(producto.getEan()).orElseThrow(null); 
	}

}
