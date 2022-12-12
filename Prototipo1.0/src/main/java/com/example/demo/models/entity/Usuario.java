/**
 * Clase que define la entidad usuario
 * Usamos la clase roles para definir los roles de los usuario
 * Estos roles se definen en el import.sql de la carpeta resources
 */
package com.example.demo.models.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.*; 


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
	private BigInteger celular;

	//foto de perfil
	private String foto;

	@Column(unique = true)
	private String email;

	//si el ususario esta activo	
	private Boolean enabled;

	private int pumapuntos;

	@Column(columnDefinition = "DATE")
	private LocalDate fecha; 

	/**
	@OneToMany
	@JoinColumn(name = "id")
	private List<Rentar> rentados; 
	**/
	
	//Prueba 
	/*
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "rentas",joinColumns = { @JoinColumn(name = "usuario_id") },inverseJoinColumns = { @JoinColumn(name = "producto_id") })
	private List<Producto> rentados;
	*/
	
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


	public BigInteger getCelular() {
		return celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}


	public int getPumapuntos() {
		return pumapuntos;
	}

	public void setPumapuntos(int pumapuntos) {
		this.pumapuntos = pumapuntos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	//Metodos de la relacion muchos a muchos con Productos para generar el ticket de rentados 
	
	/**
	 * Este metodo se encarga de agregar a la lista de productos rentados de entity.Usuario un nuevo producto 
	 * y a la lista de entity.Producto se agrega un usuario mas que lo ha rentado 
	 * @param producto
	 */
	 /*
	public void addProducto(Producto producto) {
		this.rentados.add(producto);
		producto.getUsuarios().add(this);
	}
	
	public void removeProducto(Long productoId) {
		Producto producto = this.rentados.stream().filter(p-> p.getId() == productoId).findFirst().orElse(null); 
		if(producto != null) {
			this.rentados.remove(producto); 
			producto.getRentadores().remove(this); 
		}
	}
	*/
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}





