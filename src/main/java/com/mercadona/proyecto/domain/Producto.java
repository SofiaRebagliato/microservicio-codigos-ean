package com.mercadona.proyecto.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private int codigoProducto;
	private long ean;
	private String nombre;
	private double precio;
	
}

