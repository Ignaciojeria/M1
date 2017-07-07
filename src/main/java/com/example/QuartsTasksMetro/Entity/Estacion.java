package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estacion")
public class Estacion {
	
	@Id
	@Column(name="id_estacion",unique=true, nullable=false)
	private long id_estacion;
	@Column(name="nombre",unique=true, nullable=false)
	private String nombre;
	@Column(name="abreviatura",unique=true, nullable=false)
	private String abreviatura;
	@Column(name="numero_estacion",unique=true, nullable=false)
	private long numero_estacion;
	
	public Estacion(){}

	public Estacion(long id_estacion, String nombre, String abreviatura, long numero_estacion) {
		this.id_estacion = id_estacion;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.numero_estacion = numero_estacion;
	}

	public long getId_estacion() {
		return id_estacion;
	}

	public void setId_estacion(long id_estacion) {
		this.id_estacion = id_estacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public long getNumero_estacion() {
		return numero_estacion;
	}

	public void setNumero_estacion(long numero_estacion) {
		this.numero_estacion = numero_estacion;
	}
	
	
	
	

}
