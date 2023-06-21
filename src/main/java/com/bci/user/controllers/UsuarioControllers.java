package com.bci.user.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.user.entity.Usuario;
import com.bci.user.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UsuarioControllers {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> listar() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.findAll());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable("id") UUID id) {
		
		Optional<Usuario> usuarioOptional = usuarioService.findOne(id);
		if (usuarioOptional.isPresent()) {
			 return ResponseEntity.status(HttpStatus.CREATED).body(usuarioOptional);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
	}
	
    @PostMapping("/usuarios")
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		Map<String, String> errores = validar(result);
    		return ResponseEntity.badRequest().body(errores);
    	}
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
    
    @PutMapping("/usuarios")
    public ResponseEntity<?> modificar(@RequestBody Usuario usuario, @PathVariable("id") UUID id){
    	Optional<Usuario> opUser =  usuarioService.findOne(id);
    	if (opUser.isPresent()) {
    		Usuario userDb = opUser.get();
    		userDb.setContrasenia(usuario.getContrasenia());
    		userDb.setTelefonos(usuario.getTelefonos());
    		userDb.setCorreo(usuario.getCorreo());
    		userDb.setNombre(usuario.getNombre());
    		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(userDb));
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
    	}
    }

	private Map<String, String> validar(BindingResult result) {
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), err.getDefaultMessage());
			
		});
		return errores;
	}
	   
}
