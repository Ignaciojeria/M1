package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Placa")
public class Placa {
	
	@Id
	@Column(name="id_placa",unique=true, nullable=false)
	private long idPlaca;
	@Column (name="estado")
	private boolean estado;
	@OneToOne
	@JoinColumn(name="FK_conexion")
	private Conexion conexion;
	@ManyToOne
	@JoinColumn(name="FK_estacion", nullable=false)
	private Estacion estacion;
	
	public Placa(){}

	public Placa(long idPlaca, boolean estado, Conexion conexion, Estacion estacion) {
		this.idPlaca = idPlaca;
		this.estado = estado;
		this.conexion = conexion;
		this.estacion = estacion;
	}

	public long getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(long idPlaca) {
		this.idPlaca = idPlaca;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

}
