/**
 * Clase que define la entidad producto
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author ATL
 * @author Erick Bernal Márquez
 */
@Entity
@Table(name="productos")
public class Producto implements Serializable{

	//Atributos de la entidad
	@Id
	@Column(name="serial",length = 12, nullable = false)
	private String serial;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="precio")
	private Double precio;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="dias",length = 1)
	private int dias;
	@Column(name="categoria")
	private String categoria;

	/*
	@OneToMany(mappedBy="productos", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JsonManagedReference 
	private List<Rentar> rentados = new ArrayList();
	*/
	
	//getters y setters de los atributos

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
