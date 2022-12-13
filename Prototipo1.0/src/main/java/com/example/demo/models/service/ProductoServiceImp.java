/**
 * Implementación de la interfaz de los servicios del producto
 * Para su implementacion utilizamos DAO
 */

package com.example.demo.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.models.dao.IProductoDao;
import com.example.demo.models.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private IProductoDao productoDao;

	/**
	 * Encuentra todos los productos
	 * 
	 * @return Una lista de productos
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	/**
	 * Regresa un solo por producto por id
	 * 
	 * @param id el id del producto
	 * @return el producto
	 */
	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);

	}

	/**
	 * Guarda un producto
	 * 
	 * @param producto el producto a guardar
	 * @return el producto a guardar
	 */
	@Override
	@Transactional()
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	/**
	 * Elimina un producto de acuerdo al Id
	 * 
	 * @param id el id del producto a eliminar
	 */
	@Override
	@Transactional()
	public void delete(Long id) {
		productoDao.deleteById(id);

	}

	/**
	 * Regresa un solo usuario por el nombre de usuario
	 * 
	 * @param username el username del usuario
	 * @return el usuario
	 */
	@Override
	@Transactional(readOnly = true)
	public Producto findByNombre(String nombre) {
		return productoDao.findByNombre(nombre);
	}

}
