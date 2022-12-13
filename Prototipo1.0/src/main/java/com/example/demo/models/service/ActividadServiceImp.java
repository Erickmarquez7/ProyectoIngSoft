/* Implementación de la interfaz de los servicios de las actividades
 * Para su implementacion utilizamos DAO
 */

package com.example.demo.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.models.dao.IActividadDao;
import com.example.demo.models.entity.Actividad;

@Service
public class ActividadServiceImp implements IActividadService{

	@Autowired
	private IActividadDao actividadDao;
	
	/**
	 * Encuentra todas las actividades
	 * @return Una lista de las actividades
	 */	
	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findAll() {
		return (List<Actividad>) actividadDao.findAll();
	}

	/**
	 * Regresa una sola actividad por id
	 * @param id el id de la actividad
	 * @return la actividad
	 */
	@Override
	@Transactional(readOnly=true)
	public Actividad findById(Long id) {
		return actividadDao.findById(id).orElse(null);
		
	}

	/**
	 * Guarda una actividad
	 * @param actividad la actividad a guardar
	 * @return la actividad a guardar
	 */
	@Override
	@Transactional()
	public Actividad save(Actividad actividad) {
		return actividadDao.save(actividad);
	}

	/**
	 * Elimina una actividad de acuerdo al Id
	 * @param id el id de la actividad a eliminar
	 */
	@Override
	@Transactional()
	public void delete(Long id) {
		actividadDao.deleteById(id);
		
	}

}