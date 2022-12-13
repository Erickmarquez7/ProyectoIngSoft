/**
 * DAO auxiliar para el CRUD de producto
 */
package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Actividad;

public interface IActividadDao extends CrudRepository<Actividad,String>{

}
