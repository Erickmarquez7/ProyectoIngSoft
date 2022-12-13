package com.example.demo.models.service;

import java.util.List;
import com.example.demo.models.entity.Role;

public interface IRoleService {
    /**
	 * Encuentra todos los usuarios
	 * @return Una lista de usuarios
	 */
    public List<Role> findAll();

    /**
	 * Regresa un solo por usuario por id
	 * @param id el id del usuario
	 * @return el usuario
	 */
    public Role findById(Long id);

    public Role findByNombre(String nombre);

    /**
	 * Guarda un usuario
	 * @param usuario el usuario a guardar
	 * @return el usuario a guardar
	 */
    public Role save(Role usuario);


    /**
	 * Elimina un usuario de acuerdo al Id
	 * @param id el id del usuario a eliminar
	 */
    public void delete(Long id);
    
    
    /**
     * Elimina un usuario de acuerdo al ID quitando las llaves foráneas
     */

    public void deleteById(Long id);
}
