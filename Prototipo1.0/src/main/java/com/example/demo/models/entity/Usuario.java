/**
 * 
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author DozalMagnaniDiego
 * @author ValenciaCruzJonathanJosué
 * @author RadillaMaldonadoDylanEmmanuel
 * @author OrtegaGarciaAlejandra
 * @author ReyesFarfánAndreaFernanda 
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id //Le agregamos la etiqueta de que sera la llave primaria 
	@Column(name="nocuenta", length=9, nullable=false,unique=true)
	private String noCuenta;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="paterno")
	private String paterno;
	
	@Column(name="materno")
	private String materno;
	
	@Column(name="carrera")
	private String carrera;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="rol")
	private Integer rol;
	
	@Column(name="activo")
	private Boolean activo;

	//mapped esta relacionado con el atributo tal de la clase de la lista
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	//@JsonManagedReference 
	private List<Rentar> rentados;
	
	@OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private PumaPuntos pumapuntos; 
	
	
	public String getNoCuenta() {
		return noCuenta;
	}
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public List<Rentar> getRentados() {
		return rentados;
	}
	public void setRentados(List<Rentar> rentados) {
		this.rentados = rentados;
	}
	public PumaPuntos getPumapuntos() {
		return pumapuntos;
	}
	public void setPumapuntos(PumaPuntos pumapuntos) {
		this.pumapuntos = pumapuntos;
	}
	
	
}
