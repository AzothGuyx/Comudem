package com.project.comudem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nomina")
public class Nomina {

	@Id
	private long cuenta;
	private String empresa;
	private long idEmpresa;
	
	
	public long getCuenta() {
		return cuenta;
	}
	public void setCuenta(long cuenta) {
		this.cuenta = cuenta;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	
	
}
