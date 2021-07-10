package com.subcon.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.subcon.app.dao.Usuario;
import com.subcon.app.repository.UsuariosRepository;

@RestController
public class UsuariosController {

	@Autowired
	private UsuariosRepository repositoryUsuarios;

	@PostMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario add(@RequestBody Usuario usuario) {
		return repositoryUsuarios.save(usuario);
	}

	@GetMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> login(@RequestHeader(name = "usuario", required = true) String usuario, @RequestHeader(name = "password", required = true) String password) {
		
		return repositoryUsuarios.login(usuario, password);
	}


}
