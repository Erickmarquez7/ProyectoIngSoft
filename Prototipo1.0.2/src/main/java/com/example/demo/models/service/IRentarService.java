package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.dao.IRentarDao;
import com.example.demo.models.entity.Rentar;


public interface IRentarService {

	/**
	 * Encuentra todos los Rentar
	 * @return Una lista de Rentar
	 */
	public List<Rentar> findAll();
	
	/**
	 * Regresa un solo por Rentar por id
	 * @param id el id del Rentar
	 * @return el Rentar
	 */
	public Rentar findById(Long id);
	
	/**
	 * Guarda un Rentar
	 * @param producto el Rentar a guardar
	 * @return el Rentar a guardar
	 */
	public Rentar save(Rentar producto);

	/**
	 * Elimina un Rentar de acuerdo al Id
	 * @param id el id del Rentar a eliminar
	 */
	public void delete(Long id);
	
	
	public IRentarDao getRentarDao(); 
}
