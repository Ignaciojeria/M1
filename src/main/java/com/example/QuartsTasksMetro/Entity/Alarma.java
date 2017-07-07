package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Alarma")
public class Alarma {
	
	
	@Id
	@Column(name="id_alarma")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idAlarma;
	
	@Column(name="mensaje")
	private String mensaje;
	
	@Column(name="codigoError")
	private int codigoError;
	
	@ManyToOne
	@JoinColumn(name="FK_placa", nullable=false)
	private Placa placa;
	
	public Alarma(){}

	public Alarma(String idAlarma, String mensaje, int codigoError, Placa placa) {
		this.idAlarma = idAlarma;
		this.mensaje = mensaje;
		this.codigoError = codigoError;
		this.placa = placa;
	}

	public String getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(String idAlarma) {
		this.idAlarma = idAlarma;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
}
