package com.example.demo.models.controllers;

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
import com.example.demo.models.entity.Producto;
import com.example.demo.models.service.IProductoService;

import java.util.List;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable String id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}

	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable String id){
		Producto currentproduct = productoService.findById(id);
		currentproduct.setNombre(producto.getNombre());
		currentproduct.setCantidad(producto.getCantidad());
		currentproduct.setDescripcion(producto.getDescripcion());
		currentproduct.setDias(producto.getDias());
		currentproduct.setPrecio(producto.getPrecio());
		currentproduct.setImagen(producto.getImagen());
		currentproduct.setCategoria(producto.getCategoria());
		this.productoService.save(currentproduct);
		return currentproduct;
		
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		productoService.delete(id);
	}
	}
