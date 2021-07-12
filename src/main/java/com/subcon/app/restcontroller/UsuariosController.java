package com.subcon.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
		Usuario user = repositoryUsuarios.save(usuario);
		if(user == null)
		{
			return ResponseEntity.status(500).body(user);
		}
		else
		{
			return ResponseEntity.status(200).body(user);
		}
	}

	@GetMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> login(@RequestHeader(name = "usuario", required = true) String usuario, @RequestHeader(name = "password", required = true) String password) {
		
		List<Usuario> list = repositoryUsuarios.login(usuario, password);
	
		if(list == null || list.isEmpty())
		{
			return ResponseEntity.status(204).body(list);
		}
		else
		{
			return ResponseEntity.status(200).body(list);
		}
		
	}


}
