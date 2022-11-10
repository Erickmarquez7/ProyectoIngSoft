package com.example.demo.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.models.dao.IProductoDao;
import com.example.demo.models.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}


	@Override
	@Transactional(readOnly=true)
	public Producto findById(String id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
		
	}


	@Override
	@Transactional()
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}


	@Override
	@Transactional()
	public void delete(String id) {
		productoDao.deleteById(id);
		
	}

}
