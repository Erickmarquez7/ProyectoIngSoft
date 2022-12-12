/**
 * Dao auxiliar para el CRUD del usuario
 */
package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username);

    @Query(value = "SELECT * FROM usuarios WHERE usuarios.enabled = true;", nativeQuery = true)
    public List<Usuario> getUsuariosActivos();

    /**
	* Regresa la lista del top 5 de los productos que requieren menor
	* cantidad de puma puntos.
	* @return la lista del top 5 de los productos que requieren menor
	* cantidad de puma puntos.
	*/
	@Query(
    value= "SELECT * FROM productos ORDER BY precio asc LIMIT 3;", nativeQuery = true)
    public List<Producto> masBaratos();

    /**
    * Lista de usuarios con mayor numero de rentas en la semana.
    * @return los 5 usuarios con más rentas en una semana.
    */
    @Query(
    value= "WITH aux AS ("
        + "SELECT * FROM rentar WHERE "
        + "fecha_inicio BETWEEN NOW() - INTERVAL '7 days' AND NOW()) "
        + "SELECT count(id) AS rentar, usuario_id FROM aux "
        + "GROUP BY usuario_id ORDER BY rentas DESC LIMIT 5;", 
    nativeQuery = true)
    public List<Object[]> masRentasUsuario();

    /**
    * Lista de productos más rentados en el mes.
    * @return Los 5 productos más rentados en el mes.
    */
    @Query(
    value= "WITH aux AS ("
        + "SELECT * FROM rentar WHERE "
        + "fecha_renta BETWEEN NOW() - INTERVAL '1 month' AND NOW()) "
        + "SELECT count(id) AS rentas, producto_id FROM aux "
        + "GROUP BY producto_id ORDER BY rentar DESC LIMIT 5;", 
    nativeQuery = true)
    public List<Object[]> masRentados();


    /**
    * Lista de usuarios activos por carrera.
    * @return Los usuarios activos por cada carrera.
    */
    @Query(
    value= "SELECT COUNT(id), carrera FROM usuarios WHERE enabled=true GROUP BY carrera;", 
    nativeQuery = true)
    public List<Object[]> porCarreraAct();

    /**
    * Lista de usuarios inactivos
    * @return Usuarios inactivos
    */
    @Query( 
    value= "SELECT COUNT(id), status FROM usuarios WHERE enabled=false GROUP BY enabled;", 
    nativeQuery = true)
    public List<Object[]> noActivos();
}
