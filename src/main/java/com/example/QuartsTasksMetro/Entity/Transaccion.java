package com.example.QuartsTasksMetro.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaccion")
public class Transaccion {
	
	@Column(name="fecha")
	private Date fecha;
	@Id
	@Column(name="id")
	private long id;
	@Column(name="numeroTarjeta")
	private long numeroTarjeta;
	@Column(name="puerta")
	private long puerta;
	@Column(name="estacion")
	private String estacion;
	
	public Transaccion() {}

	public Transaccion(Date fecha, long id, long numeroTarjeta, long puerta, String estacion) {
		this.fecha = fecha;
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.puerta = puerta;
		this.estacion = estacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public long getPuerta() {
		return puerta;
	}

	public void setPuerta(long puerta) {
		this.puerta = puerta;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

}
