package com.example.demo.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.models.entity.PumaPuntos;
import com.example.demo.models.service.IPumaPuntosService;

/**
 * @author DozalMagnaniDiego
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PumaPuntosController {
	
	
	@Autowired
	private IPumaPuntosService pumaPuntosService;
	
	@GetMapping("/pumapuntos")
	public List<PumaPuntos> index(){
		return pumaPuntosService.findAll(); 
	}
	
	@GetMapping("/pumapuntos/{id}")
	public PumaPuntos show(@PathVariable Long id){
		return pumaPuntosService.findById(id);		
	}
	
	@PostMapping("/pumapuntos")
	public PumaPuntos create(@RequestBody PumaPuntos pumaPuntos) {
		return pumaPuntosService.save(pumaPuntos); 
	}
	
	@PutMapping("/pumapuntos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PumaPuntos update(@RequestBody PumaPuntos pumaPuntos, @PathVariable Long id) {
		
		PumaPuntos currentPumaPuntos = pumaPuntosService.findById(id);
		currentPumaPuntos.setSaldo(pumaPuntos.getSaldo());
		currentPumaPuntos.setFechavalida(pumaPuntos.getFechavalida());; 
		this.pumaPuntosService.save(currentPumaPuntos); 
		return currentPumaPuntos; 	
	}
	
	@DeleteMapping("/pumapuntos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pumaPuntosService.delete(id);
	}
	
	
}
