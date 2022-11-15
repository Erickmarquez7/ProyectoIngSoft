package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.PumaPuntos;

public interface IPumaPuntosService {
	
	/**
	 * Encuentra todos los PumaPuntos
	 * @return Una lista de PumaPuntos
	 */
	public List<PumaPuntos> findAll();
	
	/**
	 * Regresa un solo por PumaPuntos por id
	 * @param id el id del PumaPuntos
	 * @return el PumaPuntos
	 */
	public PumaPuntos findById(String id);
	
	/**
	 * Guarda un PumaPuntos
	 * @param PumaPuntos el PumaPuntos a guardar
	 * @return el PumaPuntos a guardar
	 */
	public PumaPuntos save(PumaPuntos pumapuntos);

	/**
	 * Elimina un PumaPuntos de acuerdo al Id
	 * @param id el id del PumaPuntos a eliminar
	 */
	public void delete(String id);

}
