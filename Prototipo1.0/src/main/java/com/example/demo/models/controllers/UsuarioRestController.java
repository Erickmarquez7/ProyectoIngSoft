package com.example.demo.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.IUsuarioService;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario show(@PathVariable String id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable String id) {
        Usuario currentuser = usuarioService.findById(id);
        currentuser.setContrasena(usuario.getContrasena());
        currentuser.setNombre(usuario.getNombre());
        currentuser.setPaterno(usuario.getPaterno());
        currentuser.setMaterno(usuario.getMaterno());
        currentuser.setCarrera(usuario.getCarrera());
        currentuser.setCelular(usuario.getCelular());
        currentuser.setCorreo(usuario.getCorreo());
        currentuser.setRol(usuario.getRol());
        currentuser.setActivo(usuario.getActivo());
        this.usuarioService.save(currentuser);
        return currentuser;
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        usuarioService.delete(id);
    }
}