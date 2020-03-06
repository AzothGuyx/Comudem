package com.project.comudem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Asociado")
public class Asociado {

	@Id
	private Long idAsociado;
	private String correo;
	private String nombre;
	private String apellido;
	
	
	public Long getIdAsociado() {
		return idAsociado;
	}
	public void setIdAsociado(Long idAsociado) {
		this.idAsociado = idAsociado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	
	
}
