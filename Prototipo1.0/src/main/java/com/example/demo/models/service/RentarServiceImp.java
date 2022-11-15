package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IRentarDao;
import com.example.demo.models.entity.Rentar;
import com.example.demo.models.entity.pk.RentarPK;

@Service 
public class RentarServiceImp implements IRentarService {

	@Autowired 
	private IRentarDao rentarDao; 
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Rentar> findAll() {
		return (List<Rentar>) rentarDao.findAll();
	}

	@Override
	public Rentar findById(Long key) {
		// TODO Auto-generated method stub
		return rentarDao.findById(key).orElse(null); 
	}

	@Override
	public Rentar save(Rentar renta) {
		// TODO Auto-generated method stub
		return rentarDao.save(renta); 
	}

	@Override
	public void delete(Long key) {
		// TODO Auto-generated method stub
		rentarDao.deleteById(key);

	}

}
