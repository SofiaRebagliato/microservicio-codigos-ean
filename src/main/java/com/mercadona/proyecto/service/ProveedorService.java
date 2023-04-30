package com.mercadona.proyecto.service;

import java.util.List;

import com.mercadona.proyecto.domain.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> listaProveedores();
	
	public void guardar(Proveedor proveedor);
	
	public void eliminar(Proveedor proveedor);
	
	public Proveedor encontrarProveedor(Proveedor proveedor);
}
