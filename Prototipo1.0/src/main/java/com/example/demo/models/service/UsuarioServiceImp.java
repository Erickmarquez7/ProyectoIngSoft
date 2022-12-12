package com.example.demo.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IUsuarioDao;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.repository.usuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);

    @Autowired
    private IUsuarioDao usuarioDao;
    private usuarioRepository usuariorepository;

    /**
	 * Encuentra todos los usuarios
	 * @return Una lista de usuarios
	 */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }


    /**
	 * Regresa un solo por usuario por id
	 * @param id el id del usuario
	 * @return el usuario
	 */
    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }


    /**
	 * Guarda un usuario
	 * @param usuario el usuario a guardar
	 * @return el usuario a guardar
	 */
    @Override
    @Transactional()
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    /**
	 * Elimina un usuario de acuerdo al Id
	 * @param id el id del usuario a eliminar
	 */
    @Override
    @Transactional()
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }


    /**
	 * Carga el usuario
	 * @param username el username del usuario
	 * @return el usuario
	 */
    @Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}


    /**
	 * Regresa un solo usuario por el nombre de usuario
	 * @param username el username del usuario
	 * @return el usuario
	 */   
    @Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}


	@Override
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
	}


	

}