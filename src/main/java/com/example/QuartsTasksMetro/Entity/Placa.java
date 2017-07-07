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
	

}
