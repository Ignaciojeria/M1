package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//una tabla de alarmas por cada estación en la bdd
@Entity
@Table(name="Alarma")
public class Alarma {
	
	@Column(name="id_error")
	@Id
	private String idError;
	
	@Column(name="mensaje")
	private String mensaje;
	
	@Column(name="codigoError")
	private int codigoError;
	
	@Column(name="estado")
	private boolean estado;
	
	//no va a la base de datos!. falta clave foranea para cada uno de los registros y asociarlos a una estación
	//private String estacion="Ticketing";
	
	public Alarma(){}
	
	public Alarma(String mensaje, int codigoError, boolean estado) {
		this.mensaje = mensaje;
		this.codigoError = codigoError;
		this.estado = estado;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}
