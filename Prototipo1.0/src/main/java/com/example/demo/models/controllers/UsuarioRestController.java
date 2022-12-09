package com.example.demo.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import com.example.demo.models.entity.Actividad;
import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.IActividadService;
import com.example.demo.models.service.IProductoService;
import com.example.demo.models.service.IRentarService;
import com.example.demo.models.service.IUsuarioService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	private Date actual = new Date();

	final int maxPuntos = 500;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
	private IActividadService actividadService;
	
    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
    	Usuario usuario = null; 
    	Map<String, Object> response = new HashMap<>(); 
    	//Error al servidor, bd, etc 
    	try {
    		usuario = this.usuarioService.findById(id);
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al realizar la consulta en la base de datos.");
    		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
    	} catch (Exception e ) {
    		response.put("mensaje", "Error al realizar la consulta");
    		response.put("error", e.getMessage().concat(": "));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
    	}
    	//Error con el id ingresado 
    	if(usuario == null) {
    		response.put("mensaje", "El usuario con numero de cuenta :".concat(id.toString().concat("no existe en la base de datos")));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
    	}
    	return new ResponseEntity<Usuario>(usuario,HttpStatus.OK); 
    	
        //return usuarioService.findById(id);
    }
	
	@Secured("ROLE_ADMIN")
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        //return usuarioService.save(usuario);
    	Usuario usuarioNuevo = null; 
    	Map<String,Object> response = new HashMap<>(); 
    	try {
    		usuarioNuevo = usuarioService.save(usuario);  
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al realizar el insert en la base de datos.");
    		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 

    	}
    	response.put("mensaje", "El usuario ha sido agregado con exito.");
    	response.put("usuario", usuarioNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    }
	
	@Secured("ROLE_ADMIN")
    @PutMapping("/usuarios/form/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id) {
    	Usuario currentuser = this.usuarioService.findById(id);
    	Usuario updateduser = null; 
    	Map<String,Object> response = new HashMap<>();
    	//Error con el id ingresado
    	if(currentuser == null) {
    		response.put("mensaje", "Error : no se puede editar el usuario".concat(id.toString().concat(" no existe en la base de datos")));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 

    	}
    	try {    		
    		currentuser.setPassword(usuario.getPassword());
    		currentuser.setNombre(usuario.getNombre());
    		currentuser.setPaterno(usuario.getPaterno());
    		currentuser.setMaterno(usuario.getMaterno());
    		currentuser.setCarrera(usuario.getCarrera());
    		currentuser.setCelular(usuario.getCelular());
    		currentuser.setEmail(usuario.getEmail());
    		currentuser.setRoles(usuario.getRoles());
			currentuser.setFoto(usuario.getFoto());
    		currentuser.setEnabled(usuario.getEnabled());
			currentuser.setPumapuntos(usuario.getPumapuntos());
			currentuser.setFecha(usuario.getFecha());
    		//Esta linea por algun motivo da error mientras se iguala el update user 
    		// la que no da error es this.usuarioService.save(currentuser);
    		updateduser = this.usuarioService.save(currentuser);
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al actualizar al usuario en la base de datos");
        	response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    	}
    	
    	response.put("mensaje", "El usuario ha sido editado con exito");
    	response.put("usuario", updateduser );
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
	
	@Secured("ROLE_ADMIN")
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	Map<String,Object> response = new HashMap<>();
    	try {
    		usuarioService.delete(id);	
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al eliminar el usuario en la base de datos");
        	response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    	}
    	response.put("mensaje", "El usuario ha sido editado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping("/usuarios/{id}/{codigo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> acumulaPuntos(@PathVariable Long id, @PathVariable String codigo) {
    	Usuario currentuser = this.usuarioService.findById(id);
		Actividad actividad = this.actividadService.findById(codigo);
    	Usuario updateduser = null; 
    	Map<String,Object> response = new HashMap<>();
    	//Error con el id ingresado
    	if(currentuser == null) {
    		response.put("mensaje", "Error : no se puede editar el usuario".concat(id.toString().concat(" no existe en la base de datos")));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
    	}
    	if(actividad == null) {
    		response.put("mensaje", "Error : no existe la actividad".concat(id.toString().concat(" no existe en la base de datos")));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
    	}
    	try {    		
			int suma = actividad.getRecompensa();
			int totalPumaPuntos = currentuser.getPumapuntos() + suma; 
			if(totalPumaPuntos > 500) {
				throw new IllegalArgumentException();
			}
			currentuser.setPumapuntos(currentuser.getPumapuntos() + suma);
			updateduser = this.usuarioService.save(currentuser);
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al actualizar al usuario en la base de datos");
        	response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    	} catch (IllegalArgumentException e) {
    		response.put("mensaje", "Error al actualizar el saldo del usuario en la base de datos, El total excede el saldo maximo permitido ");
        	//response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    	}
    	
    	response.put("mensaje", "Los puntos se han registrado con éxito");
    	response.put("usuario", updateduser );
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/cuenta/{id}/{monto}/{operador}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> SumarYRestar(@RequestBody Usuario usuario, @PathVariable Long id, @PathVariable Integer monto, @PathVariable Integer operador) {
    	Usuario currentuser = this.usuarioService.findById(id);
    	Usuario updateduser = null; 
    	Map<String,Object> response = new HashMap<>();
    	int suma;
    	//Error con el id ingresado
    	if(currentuser == null) {
    		response.put("mensaje", "Error : no se puede editar el usuario".concat(id.toString().concat(" no existe en la base de datos")));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
    	}
    	try {
    		if(operador==1) {
    			suma = usuario.getPumapuntos() + monto;
    			
    			int monto_validado = monto; 
    				
    			if(suma > 500) {
    				throw new IllegalArgumentException();
    			}
    			currentuser.setPumapuntos(suma);
    		}else {
    			suma = usuario.getPumapuntos() - monto;
    			if(suma < 0) {
    				throw new IllegalArgumentException();
    			}
    			currentuser.setPumapuntos(suma);
    			
    			
    		}
			updateduser = this.usuarioService.save(currentuser);
    	} catch (DataAccessException e) {
    		response.put("mensaje", "Error al actualizar al usuario en la base de datos");
        	response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    	} catch (IllegalArgumentException e) {
    		response.put("mensaje", "Error al actualizar el saldo del usuario en la base de datos, El total sale del rango permitido");
        	//response.put("eror", e.getMessage().concat(": " ).concat(e.getMostSpecificCause().getMessage()));
    		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); 
    	}
    	
    	response.put("mensaje", "Los puntos se han registrado con éxito");
    	response.put("usuario", updateduser );
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
	
}