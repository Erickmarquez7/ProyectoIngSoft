/**
 * Clase para definir los productos rentados por los usuarios
 * Se hace a traves de del id del producto e id del usuario
 * Para hacer el join debemos unir ambos id
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author DozalMagnaniDiego
 * @author BernalMárquezErick
 */


@Entity
@Table(name="rentar")
public class Rentar implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(columnDefinition = "DATE")
	private LocalDate fechaInicio; 
	
	@Column(columnDefinition = "DATE")
	private LocalDate fechafin; 
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name="id",insertable = false, updatable = false)
	private Usuario usuario; 
	
	@Column(name = "usuario_id")
	private Long usuario_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id",insertable = false, updatable = false)
	private Producto producto;
	
	@Column(name = "producto_id")
	private Long producto_id;
	
	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}
	
	

}