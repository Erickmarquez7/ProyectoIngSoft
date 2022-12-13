/**
 * Controllador del producto
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Producto;
import com.example.demo.models.service.IProductoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	private IProductoService productoService;
	
	/**
	 * Encuentra todos los productos
	 * @return Una lista de productos
	 */
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAll();
	}
	
	/**
	 * Regresa un solo por producto por id
	 * @param id el id del producto
	 * @return el producto
	 */
	//Aqui se definen cuales roles tinene acceso al metodo
	@Secured({"ROLE_ADMIN","ROL_USER"})
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			producto = productoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if(producto == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		//return productoService.findById(id);
	}


	/**
	 * Crea y Guarda un producto
	 * @param producto el producto a guardar
	 * @return el producto a guardar
	 */	
	//se definen los roles que tienen el acceso al metodo
	@Secured("ROLE_ADMIN")
	@PostMapping("/productos")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Producto producto) {
		Producto productoNuevo= null;
		Map<String,Object> response = new HashMap<>();
		try {
			productoNuevo = productoService.save(producto);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido creado con éxito :3");
		response.put("producto", productoNuevo);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		//return productoService.save(producto);
	}

	/**
	 * Actualiza un producto por otro
	 * @param producto el producto a obtener
	 * @param id el id del producto a actualizar
	 * @return el producto actualziado
	 */
	@Secured("ROLE_ADMIN")
	@PutMapping("/productos/{id}")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id){
		Producto currentProducto = this.productoService.findById(id);
		Producto productoUpdate = null;
		Map<String,Object> response = new HashMap<>();
		//Error con el id ingresado.
		if(currentProducto == null) {
			response.put("mensaje", "Error: no se puede editar el producto ID:".concat(id.toString().concat(" no existe en la base de datos :(.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			currentProducto.setCategoria(producto.getCategoria());
			currentProducto.setNombre(producto.getNombre());
			currentProducto.setDescripcion(producto.getDescripcion());
			currentProducto.setCantidad(producto.getCantidad());
			currentProducto.setPrecio(producto.getPrecio());
			currentProducto.setDias(producto.getDias());
			currentProducto.setImagen(producto.getImagen());
			productoUpdate = productoService.save(currentProducto);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el producto en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido actualizado con éxito :3");
		response.put("producto", productoUpdate);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	/**
	 * Elimina un producto de acuerdo al Id
	 * @param id el id del producto a eliminar
	 */
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/productos/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String,Object> response = new HashMap<>();
		try {
			productoService.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el producto en la base de datos.");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	}
