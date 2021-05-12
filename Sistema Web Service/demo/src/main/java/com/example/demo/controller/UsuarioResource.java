package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuariosRepository;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuariosRepository usuarios;
	
	@PostMapping()
	public Usuario cadastraUsuario(@RequestBody @Validated Usuario usuario) {
		return usuarios.save(usuario);
	}
	
	@GetMapping(produces="application/json")
	public List<Usuario> listaUsuarios(){
		return usuarios.findAll();
	}
	
	@GetMapping("/{id}", produces="application/json")
	public ResponseEntity<Usuario> consulta(@PathVariable Long id){
		Usuario usuario = usuarios.findOne(id);
		
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
}
