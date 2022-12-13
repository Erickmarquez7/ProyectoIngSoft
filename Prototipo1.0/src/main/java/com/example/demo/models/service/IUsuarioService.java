package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Usuario;

public interface IUsuarioService {

    /**
	 * Encuentra todos los usuarios
	 * @return Una lista de usuarios
	 */
    public List<Usuario> findAll();

    /**
	 * Regresa un solo por usuario por id
	 * @param id el id del usuario
	 * @return el usuario
	 */
    public Usuario findById(Long id);

    /**
	 * Regresa un solo usuario por el nombre de usuario
	 * @param username el username del usuario
	 * @return el usuario
	 */
    public Usuario findByUsername(String username);

    /**
	 * Guarda un usuario
	 * @param usuario el usuario a guardar
	 * @return el usuario a guardar
	 */
    public Usuario save(Usuario usuario);


    /**
	 * Elimina un usuario de acuerdo al Id
	 * @param id el id del usuario a eliminar
	 */
    public void delete(Long id);

	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Usuario> getUsuariosActivos();

	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Producto> masBarato();

	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Usuario> masRentasUsuario();

	
	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Producto> masRentados();

	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Usuario> porCarreraAct();

	/**
     * Metodo perteneciente al caso de uso : Ver Reportes 
     * @return
     */
    public List<Usuario> noActivos();



}