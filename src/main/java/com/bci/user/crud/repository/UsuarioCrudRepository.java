package com.bci.user.crud.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bci.user.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, UUID>{

}
