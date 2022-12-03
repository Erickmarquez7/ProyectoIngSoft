/**
 * Dao auxiliar para el CRUD del usuario
 */
package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username);
    
    
    //@Query("SELECT u FROM usuarios u WHERE u.enabled=TRUE")
    //public List<Usuario> getUsuariosActivos();
    
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.enabled = true", nativeQuery = true)
    public List<Usuario> getUsuariosActivos();

}
