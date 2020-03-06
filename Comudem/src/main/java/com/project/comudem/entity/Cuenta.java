package com.project.comudem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")
public class Cuenta {
	
	@Id
	private long idCuenta;
	private long asociado;
	private boolean cuentaActiva;
	private double dinero;
	

	
	public long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public long getAsociado() {
		return asociado;
	}
	public void setAsociado(long asociado) {
		this.asociado = asociado;
	}

	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public boolean isCuentaActiva() {
		return cuentaActiva;
	}
	public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}
	
	
	

}
