/**
 * Clase para definir los productos rentados por los usuarios
 * Se hace a traves de del id del producto e id del usuario
 * Para hacer el join debemos unir ambos id
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DozalMagnaniDiego
 * @author BernalMárquezErick
 */


@Entity
@Table(name="rentar")
//@IdClass(Rentar.class)
public class Rentar implements Serializable {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechainicio")
	private Date fechaInicio; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechafin")
	private Date fechaFin; 
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//crea una columna llamada nocuenta y guarda el id del usuario
	@JoinColumn(name="nocuenta")

	//@Id
	//@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL )
	//@JoinColumn(name="id", insertable = false, updatable = false)
	//@ManyToOne()
	//@JoinColumn(name="id")
	private Usuario usuario;
	
	
	//@Id
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//crea una columna llamada id y guarda el id del producto
	@JoinColumn(name="id")
	//crea una columna llamada id producto y guarda el id del producto
	//@JoinColumn(name="id", insertable = false, updatable = false)
	//@ManyToOne()
	//@JoinColumn(name="id")
	private Producto producto;
	
	
	private static final long serialVersionUID = 1L;

	
	
	//public Long getId() {
	//	return id;
	//}


	//public void setId(Long id) {
	//	this.id = id;
	//}


	public Date getFechaInicio() {
		return fechaInicio;
	}

	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	
	public Date getFechaFin() {
		return fechaFin;
	}

	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	

}