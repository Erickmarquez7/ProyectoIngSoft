package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long> {
    public Role findByNombre(String nombre);
}
