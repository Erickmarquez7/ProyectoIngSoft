/**
 * Clase que define la entidad producto
 */
package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ATL
 * @author Erick Bernal Márquez
 */
@Entity
@Table(name="productos")
public class Producto implements Serializable{

	//Atributos de la entidad
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //siguiendo la estrategia de autoincremento
	private String Id;
	
	@Column(name="categoria")
	private String categoria;

	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="cantidad")
	private int cantidad;

	@Column(name="precio")
	private Double precio;
	
	@Column(name="dias",length = 1)
	private int dias;
	
	//getters y setters de los atributos del productos
	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}