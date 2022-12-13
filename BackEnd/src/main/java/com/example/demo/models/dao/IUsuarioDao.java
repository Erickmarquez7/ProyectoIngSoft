/**
 * Dao auxiliar para el CRUD del usuario
 */
package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.entity.Rentar;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username);
    
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.enabled = true", nativeQuery = true)
    public List<Usuario> getUsuariosActivos();

        /**
	    * Regresa la lista del top 5 de los productos que requieren menor
	    * cantidad de puma puntos.
	    * @return la lista del top 5 de los productos que requieren menor
	    * cantidad de puma puntos.
	    */
	    @Query(value= "SELECT * FROM productos ORDER BY precio asc LIMIT 5", nativeQuery = true)
        public List<Producto> masBaratos();


     /**
    * Lista de usuarios con mayor numero de rentas en la semana.
    * @return los 5 usuarios con más rentas en una semana.
    */
    @Query(value= "WITH aux(iden) AS (SELECT usuario_id FROM rentar WHERE fecha_inicio BETWEEN NOW() - INTERVAL '7 days' AND NOW()) SELECT id, carrera, celular, email, enabled, fecha, foto, materno, nombre, paterno, password, pumapuntos, username FROM usuarios, aux WHERE usuarios.id=aux.iden GROUP BY usuarios.id, aux.iden;", nativeQuery = true)
    public List<Usuario> masRentasUsuario();

    /**
    * Lista de productos más rentados en el mes.
    * @return Los 5 productos más rentados en el mes.
    */
    @Query(
    value= "WITH aux(iden) AS "
    + "(SELECT producto_id FROM rentar "
    + "WHERE fecha_inicio BETWEEN NOW()"
    + " - INTERVAL '1 Month' AND NOW()) "
    + " SELECT id, categoria, nombre, descripcion, cantidad, precio, dias"
    + " FROM productos, aux WHERE productos.id=aux.iden"
    + " GROUP BY productos.id, aux.iden;",  
    nativeQuery = true)
    public List<Producto> masRentados();


    /**
    * Lista de usuarios activos por carrera.
    * @return Los usuarios activos por cada carrera.
    */
    @Query(value= "SELECT * FROM usuarios WHERE enabled=true ORDER BY carrera;", nativeQuery = true)
    public List<Usuario> porCarreraAct();

    /**
    * Lista de usuarios inactivos
    * @return Usuarios inactivos
    */
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.enabled = false;", nativeQuery = true)
    public List<Usuario> noActivos();
}
