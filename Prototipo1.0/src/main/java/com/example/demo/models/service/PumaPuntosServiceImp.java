package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IPumaPuntosDao;
import com.example.demo.models.entity.PumaPuntos;

@Service
public class PumaPuntosServiceImp implements IPumaPuntosService {

	@Autowired
	private IPumaPuntosDao pumaPuntosDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<PumaPuntos> findAll() {
		// TODO Auto-generated method stub
		return (List<PumaPuntos>) pumaPuntosDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public PumaPuntos findById(Long id) {
		// TODO Auto-generated method stub
		return pumaPuntosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public PumaPuntos save(PumaPuntos pumapuntos) {
		// TODO Auto-generated method stub
		return pumaPuntosDao.save(pumapuntos);
	}

	@Override
	@Transactional()
	public void delete(Long id) {
		pumaPuntosDao.deleteById(id);

	}

}
