package com.example.QuartsTasksMetro.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tarjeta")
public class Tarjeta {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	private long id;
	
	@Id
	@Column(name="codigoTarjeta", unique=true, nullable=false)
	private long codigoTarjeta;
	
	@Column(name="activa", nullable=false)
	private boolean activa;
	
	@Column(name="fechaInicial", nullable=false)
	private Date fechaInicial;
	
	@Column(name="fechaExpiracion", nullable=false)
	private Date fechaExpiracion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_rut")
	private Usuario usuario;

	public Tarjeta(){}
	
	public Tarjeta(long id, long codigoTarjeta, boolean activa, Date fechaInicial, Date fechaExpiracion, Usuario usuario) {
		this.id = id;
		this.codigoTarjeta = codigoTarjeta;
		this.activa = activa;
		this.fechaInicial = fechaInicial;
		this.fechaExpiracion = fechaExpiracion;
		this.usuario=usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public void setCodigoTarjeta(long codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Date isFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date isFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	
	
	

}
