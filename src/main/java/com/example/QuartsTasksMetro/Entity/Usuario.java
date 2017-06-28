package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="Usuario")
public class Usuario {
	private long id;
	private String nombre;
	private int edad;
	private int rut;
	private boolean activo;
	private Transaccion transaccion;
}
