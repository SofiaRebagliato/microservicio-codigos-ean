package com.mercadona.proyecto.service;

import java.util.List;

import com.mercadona.proyecto.domain.Producto;

public interface ProductoService {
	
	public List<Producto> listaProductos();
	
	public void guardar(Producto producto);
	
	public void eliminar(Producto producto);
	
	public Producto encontrarProducto(Producto producto);
}
