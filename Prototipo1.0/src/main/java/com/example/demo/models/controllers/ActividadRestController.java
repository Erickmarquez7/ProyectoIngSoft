/**
 * Controllador de la actividad
 */
package com.example.demo.models.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Actividad;
import com.example.demo.models.service.IActividadService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ActividadRestController {

	@Autowired
	private IActividadService actividadService;
	
	/**
	 * Encuentra todos los actividades
	 * @return Una lista de actividades
	 */
	@GetMapping("/actividades")
	public List<Actividad> index(){
		return actividadService.findAll();
	}
	
	/**
	 * Regresa un solo por actividad por id
	 * @param id el id de la actividad
	 * @return la actividad
	 */
	//Aqui se definen cuales roles tinene acceso al metodo
	@Secured({"ROLE_ADMIN","ROL_USER"})
	@GetMapping("/actividades/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Actividad actividad = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			actividad = actividadService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(actividad == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Actividad>(actividad, HttpStatus.OK);
		//return actividadService.findById(id);
	}


	/**
	 * Crea y Guarda un actividad
	 * @param actividad la actividad a guardar
	 * @return la actividad a guardar
	 */	
	//se definen los roles que tienen el acceso al metodo
	@Secured("ROLE_ADMIN")
	@PostMapping("/actividades")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Actividad actividad) {
		Actividad productoNuevo= null;
		Map<String,Object> response = new HashMap<>();
		try {
			productoNuevo = actividadService.save(actividad);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La actividad ha sido creado con éxito :3");
		response.put("actividad", productoNuevo);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		//return actividadService.save(actividad);
	}

	/**
	 * Actualiza un actividad por otro
	 * @param actividad la actividad a obtener
	 * @param id el id de la actividad a actualizar
	 * @return la actividad actualziado
	 */
	@Secured("ROLE_ADMIN")
	@PutMapping("/actividades/{id}")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Actividad actividad, @PathVariable Long id){
		Actividad currentActividad = this.actividadService.findById(id);
		Actividad productoUpdate = null;
		Map<String,Object> response = new HashMap<>();
		//Error con el id ingresado.
		if(currentActividad == null) {
			response.put("mensaje", "Error: no se puede editar la actividad ID:".concat(id.toString().concat(" no existe en la base de datos :(.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			currentActividad.setCategoria(actividad.getCategoria());
			currentActividad.setNombre(actividad.getNombre());
			currentActividad.setDescripcion(actividad.getDescripcion());
			currentActividad.setRecompensa(actividad.getRecompensa());
			productoUpdate = actividadService.save(currentActividad);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la actividad en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La actividad ha sido actualizado con éxito :3");
		response.put("actividad", productoUpdate);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	/**
	 * Elimina un actividad de acuerdo al Id
	 * @param id el id de la actividad a eliminar
	 */
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/actividades/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String,Object> response = new HashMap<>();
		try {
			actividadService.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la actividad en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La actividad ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	}
