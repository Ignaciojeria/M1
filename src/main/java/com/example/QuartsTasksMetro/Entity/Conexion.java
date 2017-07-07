package com.example.QuartsTasksMetro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Conexion")
public class Conexion {
	
	@Id
	@Column(name="id",unique=true, nullable=false)
	private long id;
	@Column(name="protocol")
	private String protocol;
	@Column(name="ipaddress")
	private String ipaddress;
	@Column(name="port")
	private String port;
	@Column(name="timeout")
	private String timeout;
	@Column(name="passwd")
	private String passwd;
	
	public Conexion(){}
	
	public Conexion(long id, String protocol, String ipaddress, String port, String timeout, String passwd) {
		this.id = id;
		this.protocol = protocol;
		this.ipaddress = ipaddress;
		this.port = port;
		this.timeout = timeout;
		this.passwd = passwd;
	}

	public long getConnectionId() {
		return id;
	}

	public void setConnectionId(long id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
	
	
}
