package com.project.comudem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditos")
public class Credito {

	@Id
	private long idCredito;
	private long idBanco;
	private String banco;
	private double monto;
	private long idAsociado;
	
	
	
	public long getIdCredito() {
		return idCredito;
	}
	public void setIdCredito(long idCredito) {
		this.idCredito = idCredito;
	}
	public long getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public long getIdAsociado() {
		return idAsociado;
	}
	public void setIdAsociado(long idUsuario) {
		this.idAsociado = idUsuario;
	}
	
	
	
	
}
