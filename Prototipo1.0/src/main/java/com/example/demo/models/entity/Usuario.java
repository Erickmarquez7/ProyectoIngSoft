/**
 * Clase que define la entidad usuario
 * Usamos la clase roles para definir los roles de los usuario
 * Estos roles se definen en el import.sql de la carpeta resources
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//contrasena
	@Column(length = 60)
	private String password;

	//no cuenta sera el username
	@Column(unique = true, length = 9)
	private String username;

	//nombre
	private String nombre;

	//ap. paterno
	private String paterno;

	//ap. materno
	private String materno;

	//carrera
	private String carrera;

	//cel
	private int celular;

	@Column(unique = true)
	private String email;

	//si el ususario esta activo	
	private Boolean enabled;
	
	
	//mapped esta relacionado con el atributo tal de la clase de la lista
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	//@JsonManagedReference 
	private List<Rentar> rentados;
		
	@OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private PumaPuntos pumapuntos;
	
	//el rol
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "role_id"})})
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}





