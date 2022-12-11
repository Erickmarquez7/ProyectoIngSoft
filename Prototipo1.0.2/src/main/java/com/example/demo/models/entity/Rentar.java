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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "producto_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Producto producto;
	
	@Column(columnDefinition = "varchar(255)")
	private String nombreProducto;
	
	public Rentar() {
		super();
	}
	
	public Rentar(Long id, LocalDate fechaInicio, LocalDate fechafin, Usuario usuario, Producto producto) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechafin = fechafin;
		this.usuario = usuario;
		this.producto = producto;
		this.nombreProducto = producto.getNombre();
		
	}
	
	
	
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
	
	public String getNombreProducto(){
		return nombreProducto;
	}
	
	public void setNombreProducto() {
		this.nombreProducto = this.producto.getNombre();
	}
	

		
	
	
	

}