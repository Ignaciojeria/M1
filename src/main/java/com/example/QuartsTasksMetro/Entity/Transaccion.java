package com.example.QuartsTasksMetro.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaccion")
public class Transaccion {
	
	@Column(name="fechaTransaccion", nullable=false)
	private Date fechaTransaccion;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="numeroTransaccion",unique=true, nullable=false)
	private long numeroTransaccion;
	
	@Column(name="estacion")
	private String estacion;
	
	@Column(name="puerta")
	private int puerta;
	
	@ManyToOne
	@JoinColumn(name="FK_codigoTarjeta", nullable=false)
	private Tarjeta tarjeta;
	
	public Transaccion(){}

	public Transaccion(Date fechaTransaccion, long numeroTransaccion, String estacion, int puerta, Tarjeta tarjeta) {
		this.fechaTransaccion = fechaTransaccion;
		this.numeroTransaccion = numeroTransaccion;
		this.estacion = estacion;
		this.puerta = puerta;
		this.tarjeta = tarjeta;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public long getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(long numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

	public int getPuerta() {
		return puerta;
	}

	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

}
