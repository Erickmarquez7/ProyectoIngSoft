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

@Entity
@Table(name="rentar")
@IdClass(Rentar.class)
public class Rentar implements Serializable {
	
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
	private Usuario usuario;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//crea una columna llamada id y guarda el id del producto
	@JoinColumn(name="id")
	private Producto producto;
	
	
	private static final long serialVersionUID = 1L;

	
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
	
	

}