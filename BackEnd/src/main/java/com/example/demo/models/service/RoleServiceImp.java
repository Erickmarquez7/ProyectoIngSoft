package com.example.demo.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IRoleDao;
import com.example.demo.models.entity.Role;

@Service
public class RoleServiceImp implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        return (List<Role>) roleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
	@Transactional(readOnly=true)
    public Role findByNombre(String nombre) {
        return roleDao.findByNombre(nombre);
    }

    /**
	 * Guarda un usuario
	 * @param usuario el usuario a guardar
	 * @return el usuario a guardar
	 */
    @Override
    @Transactional()
    public Role save(Role role) {
        return roleDao.save(role);
    }

    /**
	 * Elimina un usuario de acuerdo al Id
	 * @param id el id del usuario a eliminar
	 */
    @Override
    @Transactional()
    public void delete(Long id) {
        roleDao.deleteById(id);
    }

    @Override
	public void deleteById(Long id) {
		roleDao.deleteById(id);
	}

}
