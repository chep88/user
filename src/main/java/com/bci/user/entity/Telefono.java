package com.bci.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "telefonos")
public class Telefono {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Column(unique=true)
	private Integer numero;
	
	@ManyToOne
	private Usuario usuario;
	
	
	private Integer codigoCiudad;
	
	
	private Integer codigoPais;
	
	
	public Telefono() {
	}
	
	
	public Telefono(Integer id, Integer numero, Usuario usuario, Integer codigoCiudad, Integer codigoPais) {
		super();
		this.id = id;
		this.numero = numero;
		this.usuario = usuario;
		this.codigoCiudad = codigoCiudad;
		this.codigoPais = codigoPais;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getCodigoCiudad() {
		return codigoCiudad;
	}
	public void setCodigoCiudad(Integer codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}
	public Integer getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}
	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + ", usuario=" + usuario + ", codigoCiudad=" + codigoCiudad
				+ ", codigoPais=" + codigoPais + "]";
	}
	
	
	
	
}
