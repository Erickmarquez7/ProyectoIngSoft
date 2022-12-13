/**
 * Interfaz para los servicios de las actividades
 */

package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Actividad;


public interface IActividadService {

	/**
	 * Encuentra todas las actividades
	 * @return Una lista de las actividades
	 */
	public List<Actividad> findAll();
	
	/**
	 * Regresa una sola actividad por id
	 * @param id el id de la actividad
	 * @return la actividad
	 */
	public Actividad findById(String id);
	
	/**
	 * Guarda un producto
	 * @param producto el producto a guardar
	 * @return el producto a guardar
	 */
	public Actividad save(Actividad actividad);

	/**
	 * Elimina un producto de acuerdo al Id
	 * @param id el id del producto a eliminar
	 */
	public void delete(String id);
}
