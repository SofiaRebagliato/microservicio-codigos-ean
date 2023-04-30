package com.mercadona.proyecto.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadona.proyecto.domain.Producto;
import com.mercadona.proyecto.service.ProductoService;
import com.mercadona.proyecto.utils.Endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(Endpoints.PROJECT)
public class ControladorProducto {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping(Endpoints.INIT)
	public ResponseEntity<String> inicio(Model model){
		Iterable<Producto> productos = productoService.listaProductos();
		log.info("Ejecutando el controlador Spring MVC");
		model.addAttribute("productos", productos);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.ADD)
	public ResponseEntity<String> agregar(Producto producto){	
		log.info("Agregando un nuevo producto");
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.SAVE)
	public ResponseEntity<String> guardar(Producto producto) {
		log.info("Guardando producto");
		productoService.guardar(producto);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.EDIT_PRODUCT)
	public ResponseEntity<String> editar(Producto producto, Model model) {
		log.info("Editando producto");
		producto = productoService.encontrarProducto(producto);
		model.addAttribute("producto", producto);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.DELETE_PRODUCT)
	public ResponseEntity<String> eliminar(Producto producto) {
		log.info("Eliminando producto");
		productoService.eliminar(producto);
		return ResponseEntity.ok("");
	}
}

