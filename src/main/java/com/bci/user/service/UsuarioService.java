package com.bci.user.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bci.user.entity.Usuario;

public interface UsuarioService {
	List <Usuario> findAll();
	Optional<Usuario> findOne(UUID id);
	Usuario save(Usuario usuario);
	
	
}
