/**
 * Interfaz para los servicios del producto
 */

package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Producto;


public interface IProductoService {

	/**
	 * Encuentra todos los productos
	 * @return Una lista de productos
	 */
	public List<Producto> findAll();
	
	/**
	 * Regresa un solo por producto por id
	 * @param id el id del producto
	 * @return el producto
	 */
	public Producto findById(Long id);
	
	/**
	 * Regresa un solo usuario por el nombre de usuario
	 * @param username el username del usuario
	 * @return el usuario
	 */
    public Producto findByNombre(String nombre);

	/**
	 * Guarda un producto
	 * @param producto el producto a guardar
	 * @return el producto a guardar
	 */
	public Producto save(Producto producto);

	/**
	 * Elimina un producto de acuerdo al Id
	 * @param id el id del producto a eliminar
	 */
	public void delete(Long id);
}
