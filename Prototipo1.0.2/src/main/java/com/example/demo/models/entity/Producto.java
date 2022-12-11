/**
 * Clase que define la entidad producto
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long id;
	
	@Column(name="categoria")
	private String categoria;

	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="cantidad")
	private int cantidad;

	//precio pero en realidad son los puma puntos que cuestan
	@Column(name="precio")
	private Double precio;

	@Column(name="imagen")
	private String imagen;
	
	@Column(name="dias",length = 1)
	private int dias;
	
	/*@OneToMany
	@JoinColumn(name = "id")
	private List<Rentar> rentados; 
	*/
	/*
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "productos")
	@JsonIgnore
	private List<Usuario> rentadores; 
	*/
	
	
	
	
	//getters y setters de los atributos del productos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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