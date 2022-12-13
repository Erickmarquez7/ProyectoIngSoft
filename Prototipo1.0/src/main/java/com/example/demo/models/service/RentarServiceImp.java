package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IRentarDao;
import com.example.demo.models.entity.Rentar;

@Service
public class RentarServiceImp implements IRentarService {

	@Autowired
	private IRentarDao rentarDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<Rentar> findAll() {
		// TODO Auto-generated method stub
		return (List<Rentar>) rentarDao.findAll();	}

	@Override
	@Transactional(readOnly=true)
	public Rentar findById(Long id) {
		// TODO Auto-generated method stub
		return rentarDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Rentar save(Rentar producto) {
		// TODO Auto-generated method stub
		return rentarDao.save(producto);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		rentarDao.deleteById(id);

	}

}
