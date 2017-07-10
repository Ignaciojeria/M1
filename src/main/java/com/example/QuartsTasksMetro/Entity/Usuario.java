package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellidos", nullable=false)
	private String apellidos;
	
	@Column(name="edad", nullable=false)
	private int edad;
	
	@Id
	@Column(name="rut", unique=true, nullable=false)
	private int rut;
	
	@Column(name="dvrut", nullable=false)
	private char dvrut;
	

	
	public Usuario(){}

	public Usuario(String nombre, String apellidos, int edad, int rut, char dvrut) {
		this.nombre = nombre;
		this.apellidos=apellidos;
		this.edad = edad;
		this.rut = rut;
		this.dvrut = dvrut;
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
	
	public String getApellidos(){
		return apellidos;
	}
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
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

	public char getDvrut() {
		return dvrut;
	}

	public void setDvrut(char dvrut) {
		this.dvrut = dvrut;
	}
	
	
	
	
	
}
