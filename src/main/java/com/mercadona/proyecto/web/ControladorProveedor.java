package com.mercadona.proyecto.web;

import com.mercadona.proyecto.domain.Proveedor;
import com.mercadona.proyecto.service.ProveedorService;
import com.mercadona.proyecto.utils.Endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(Endpoints.PROJECT)
public class ControladorProveedor {

	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping(Endpoints.INIT)
	public ResponseEntity<String> inicio(Model model) {
		Iterable<Proveedor> proveedores = proveedorService.listaProveedores();
		log.info("Ejecutando el controlador Spring MVC");
		model.addAttribute("proveedores", proveedores);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.ADD)
	public ResponseEntity<String> agregar(Proveedor proveedor) {
		log.info("Agregando un nuevo proveedor");
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.SAVE)
	public ResponseEntity<String> guardar(Proveedor proveedor) {
		log.info("Guardando proveedor");
		proveedorService.guardar(proveedor);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.EDIT_SUPPLIER)
	public ResponseEntity<String> editar(Proveedor proveedor, Model model) {
		log.info("Editando proveedor");
		proveedor = proveedorService.encontrarProveedor(proveedor);
		model.addAttribute("proveedor", proveedor);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.DELETE_SUPPLIER)
	public ResponseEntity<String> eliminar(Proveedor proveedor) {
		log.info("Eliminando proveedor");
		proveedorService.eliminar(proveedor);
		return ResponseEntity.ok("");
	}
}

