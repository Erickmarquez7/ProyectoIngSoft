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

import com.example.demo.models.entity.Rentar;
import com.example.demo.models.service.IRentarService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RentarRestController {
	
	@Autowired
	private IRentarService rentarService; 
	
	
	@GetMapping("/rentar")
	public List<Rentar> index(){
		return rentarService.findAll(); 
	}
	
	@GetMapping("/rentar/{id}")
	public Rentar show(@PathVariable Long id){
		return rentarService.findById(id);		
	}
	
	@PostMapping("/rentar")
	public Rentar create(@RequestBody Rentar renta) {
		return rentarService.save(renta); 
	}
	
	@PutMapping("/rentar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rentar update(@RequestBody Rentar renta, @PathVariable Long id) {
		
		Rentar currentRenta = rentarService.findById(id);
		currentRenta.setFechaInicio(renta.getFechaInicio()); 
		currentRenta.setFechaFin(renta.getFechaFin()); 
		this.rentarService.save(currentRenta); 
		return currentRenta; 
		
	}
	
	@DeleteMapping("/rentar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		rentarService.delete(id);
	}
	
}
