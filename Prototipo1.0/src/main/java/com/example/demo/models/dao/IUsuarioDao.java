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
	    @Query(
        value= "SELECT * FROM productos ORDER BY precio asc LIMIT 3", 
        nativeQuery = true)
        public List<Producto> masBaratos();

        /**
        * Regresa la lista de los 5 usuarios con mayor cantidad de rentas en la semana.
        * @return la lista de los 5 usuarios con mayor cantidad de rentas en la semana.
        */
        @Query(
        value= "WITH aux AS ("
            + "SELECT * FROM rentar WHERE "
            + "fecha_inicio BETWEEN NOW() - INTERVAL '1 month' AND NOW()) "
            + "SELECT count(id) AS rentar, usuario_id FROM aux "
            + "GROUP BY usuario_id ORDER BY rentas DESC LIMIT 3;", 
        nativeQuery = true)
        public List<Object[]> masRentas();

        /**
        * Regresa la lista de los 5 productos mas rentados del mes.
        * @return la lista de los 5 productos mas rentados del mes.
        */
        @Query(
        value= "WITH aux AS ("
            + "SELECT * FROM rentar WHERE "
            + "fecha_renta BETWEEN NOW() - INTERVAL '1 month' AND NOW()) "
            + "SELECT count(id) AS rentas, producto_id FROM aux "
            + "GROUP BY producto_id ORDER BY rentar DESC LIMIT 3;", 
        nativeQuery = true)
        public List<Object[]> masRentados();


        /**
        * Agrupar usuarios por carrera.
        * @return una lista de usuarios agrupados por su carrera.
        */
        @Query(
        value= "SELECT COUNT(noCT), carrera FROM usuarios WHERE enabled=true GROUP BY carrera ", 
        nativeQuery = true)
        public List<Object[]> porCarrera();

        /**
        * Regresa la lista de usuarios agrupada por cuentas activas e inactivas.
        * @return la lista de usuarios agrupada por cuentas activas e inactivas.
        */
        @Query( 
        value= "SELECT COUNT(noCT), status FROM usuarios GROUP BY enabled ", 
        nativeQuery = true)
        public List<Object[]> status();
}
