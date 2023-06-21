package com.bci.user.service;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bci.user.crud.repository.UsuarioCrudRepository;
import com.bci.user.entity.Telefono;
import com.bci.user.entity.Usuario;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioCrudRepository usuarioRepositorio;
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepositorio.findAll();
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findOne(UUID id) {
		
		Optional<Usuario> userOpt = usuarioRepositorio.findById(id);
		return userOpt;
		
	}
	
	
	
	@Transactional
	@Override
	public Usuario save(Usuario usuario) {
		System.out.println("Ingreso al UsuarioService  ");
		
		Usuario newUsuario = new Usuario();
		
		newUsuario.setContrasenia(usuario.getContrasenia());
		newUsuario.setCorreo(usuario.getCorreo());
		newUsuario.setNombre(usuario.getNombre());
		newUsuario.setContrasenia(usuario.getContrasenia());
		newUsuario.setContrasenia(usuario.getContrasenia());
		newUsuario.setActive(true);
		newUsuario.setId(UUID.randomUUID());
		newUsuario.setCreatedAt(LocalDateTime.now());
		newUsuario.setLastLogin(usuario.getCreatedAt());
		newUsuario.setToken(UUID.randomUUID());
		
		for (Telefono telefono : usuario.getTelefonos()) {
			
			Telefono newTelefono = new Telefono();
			newTelefono.setCodigoCiudad(telefono.getCodigoCiudad());
			newTelefono.setNumero(telefono.getNumero());
			newTelefono.setCodigoPais(telefono.getCodigoPais());
			newTelefono.setUsuario(newUsuario);
			newUsuario.addTelefono(newTelefono);
		}
	    
		Usuario usuarioGuardado = usuarioRepositorio.save(newUsuario);
		return usuarioGuardado;
	}

}
