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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Actividad;
import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Rentar;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.IProductoService;
import com.example.demo.models.service.IRentarService;
import com.example.demo.models.service.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RentarRestController {

	
	@Autowired
	private IRentarService rentarService; 
	
	@Autowired
	private IUsuarioService usuarioService; 
	
	@Autowired
	private IProductoService productoService; 
	
	@GetMapping("/rentas")
	public List<Rentar> index(){
		return rentarService.findAll();
	}
	
	
	@Secured({"ROLE_ADMIN","ROL_USER"})
	@GetMapping("/rentas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Rentar renta = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			renta = rentarService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(renta == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Rentar>(renta, HttpStatus.OK);
		//return actividadService.findById(id);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/rentas/{id_usuario}/{id_producto}")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Rentar renta, @PathVariable Long id_usuario, @PathVariable Long id_producto ) {
		
		Usuario rentador = usuarioService.findById(id_usuario); 
		renta.setUsuario(rentador); 
		renta.setUsuario_id(rentador.getId());
	
		Producto rentado = productoService.findById(id_producto);
		renta.setProducto(rentado); 
		renta.setProducto_id(renta.getProducto().getId());
		//renta.setProducto_id(renta.getProducto().getId());
		
		Map<String,Object> response = new HashMap<>();
		try {
			renta = rentarService.save(renta); 
		}catch(DataAccessException e) {
			
			System.out.print("Id Usuario : "+ renta.getUsuario().getId()); 
			System.out.print(" Id Producto : "+ renta.getProducto().getId());
			
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La actividad ha sido creado con éxito :3");
		response.put("actividad", renta);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		//return actividadService.save(actividad);
	}
	
}





