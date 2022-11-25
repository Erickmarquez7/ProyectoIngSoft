package com.example.demo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "DELETE FROM usuarios u WHERE u.id = ?", nativeQuery = true)
	void deleteById(Long id);
}
