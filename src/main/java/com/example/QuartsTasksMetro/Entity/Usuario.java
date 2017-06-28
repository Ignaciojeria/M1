package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="edad", nullable=false)
	private int edad;
	
	@Id
	@Column(name="rut", unique=true, nullable=false)
	private int rut;
	
	@Column(name="dvrut", nullable=false)
	private int dvrut;
	
	@OneToOne
	@JoinColumn(name="FK_codigoTarjeta")
	private Tarjeta tarjeta;
	
	public Usuario(){}

	public Usuario(String nombre, int edad, int rut, int dvrut, Tarjeta tarjeta) {
		this.nombre = nombre;
		this.edad = edad;
		this.rut = rut;
		this.dvrut = dvrut;
		this.tarjeta=tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public int getDvrut() {
		return dvrut;
	}

	public void setDvrut(int dvrut) {
		this.dvrut = dvrut;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	
	
	
}
