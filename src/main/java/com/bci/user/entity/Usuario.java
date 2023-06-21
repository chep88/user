package com.bci.user.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	private UUID id;
	
	@NotEmpty(message = "Nombre de Usuario debe venir")
	private String nombre;
	 
	@Email(message = "Ingrese un correo correcto aaaaaaa@dominio.cl")
	@Column(unique=true)
	private String correo;
	
	@NotEmpty(message = "Contraseña de Usuario debe venir")
	private String contrasenia;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private List<Telefono> telefonos =  new ArrayList<Telefono>();
	
	
	private UUID token;
	private boolean isActive;
	
	@Column(name = "created_at")
    private LocalDateTime createdAt;
	
	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	
	public Usuario(UUID id, String nombre, String correo, String contrasenia, List<Telefono> telefonos, UUID token,
			boolean isActive, LocalDateTime createdAt, LocalDateTime lastLogin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.telefonos = telefonos;
		this.token = token;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
	}



	public Usuario() {
	}


	
	public void addTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}

	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	

	public List<Telefono> getTelefonos() {
		return telefonos;
	}



	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}



	public UUID getToken() {
		return token;
	}



	public void setToken(UUID token) {
		this.token = token;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasenia=" + contrasenia
				+ ", telefonos=" + telefonos.toString() + ", token=" + token + ", isActive=" + isActive + ", createdAt="
				+ createdAt + ", lastLogin=" + lastLogin + "]";
	}
    
	 
}
