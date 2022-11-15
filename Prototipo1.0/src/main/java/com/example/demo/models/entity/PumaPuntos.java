package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author DozalMagnaniDiego
 */

@Entity
@Table(name = "pumapuntos")
public class PumaPuntos implements Serializable {
	
	@Id
	@Column(name="id", length=5, nullable=false,unique=true)
	private String id; 
	
	@Column(name="saldo")
	private Integer saldo; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechavalida")
	private Date fechavalida; 
	
	@OneToOne
	@JoinColumn(name="nocuenta")
	Usuario usuario; 
	
	
	private static final long serialVersionUID = 1L;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getSaldo() {
		return saldo;
	}


	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}


	public Date getFechavalida() {
		return fechavalida;
	}


	public void setFechavalida(Date fechavalida) {
		this.fechavalida = fechavalida;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
