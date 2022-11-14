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
	@JoinColumn(name="nocuenta")
	private Usuario usuario;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	//crea una columna llamada id producto y guarda el id del producto
	@JoinColumn(name="idproducto")
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