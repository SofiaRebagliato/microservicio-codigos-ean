package com.mercadona.proyecto.web;

import com.mercadona.proyecto.domain.Destino;
import com.mercadona.proyecto.service.DestinoService;
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
public class ControladorDestino {

	@Autowired
	private DestinoService destinoService;
	
	@PostMapping(Endpoints.INIT)
	public ResponseEntity<String> inicio(Model model) {
		Iterable<Destino> Destinos = destinoService.listaDestinos();
		log.info("Ejecutando el controlador Spring MVC");
		model.addAttribute("Destinos", Destinos);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.ADD)
	public ResponseEntity<String> agregar(Destino destino) {
		log.info("Agregando un destino nuevo");
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.SAVE)
	public ResponseEntity<String> guardar(Destino destino) {
		log.info("Guardando destino");
		destinoService.guardar(destino);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.EDIT_DESTINY)
	public ResponseEntity<String> editar(Destino destino, Model model) {
		log.info("Editando destino");
		destino = destinoService.encontrarDestino(destino);
		model.addAttribute("destino", destino);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(Endpoints.DELETE_DESTINY)
	public ResponseEntity<String> eliminar(Destino destino) {
		log.info("Eliminando destino");
		destinoService.eliminar(destino);
		return ResponseEntity.ok("");
	}
}

