package com.example.demo.models.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.entity.Rentar;

public interface IRentarDao extends JpaRepository<Rentar, Long> {
	
	List<Rentar> findByUsuarioId(Long postId); 
	
	List<Rentar> findByProductoId(Long postId); 
	
	@Transactional
	void deleteByUsuarioId(Long usuarioId); 
	
	@Transactional
	void deleteByProductoId(Long productoId); 
	

}
