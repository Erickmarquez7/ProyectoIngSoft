/**
 * Clase que define la entidad actividad
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ATL
 * @author Dylan Emmanuel Radilla
 */
@Entity
@Table(name="actividades")
public class Actividad implements Serializable{

	//Atributos de la entidad
	@Id
	private Long id;
	
	@Column(name="categoria")
	private String categoria;

	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="recompensa")
	private int recompensa;

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


	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}