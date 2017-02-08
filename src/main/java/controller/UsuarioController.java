package br.com.fabio.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.fabio.model.*;
import br.com.fabio.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	
	@RequestMapping(method=RequestMethod.GET, value="/usuario")
	public void buscar(){
		
		System.out.println("Chamou /usuario");
	}
	

	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarTodosUsuarios() {

		Collection<Usuario> usuariosBuscados = usuarioService.buscarTodos();

		return new ResponseEntity<>(usuariosBuscados, HttpStatus.OK);
	}
	

}
