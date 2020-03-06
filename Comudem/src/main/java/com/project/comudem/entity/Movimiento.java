package com.project.comudem.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movimiento")
public class Movimiento {

	
	
	@Id
	private long idMovimiento;
	private long idAsociado;
	private String tipo;
	private double cantidad;
	private String fecha;
	
	
	
	
	public long getIdAsociado() {
		return idAsociado;
	}
	public void setIdAsociado(long idUsuario) {
		this.idAsociado = idUsuario;
	}
	public long getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
