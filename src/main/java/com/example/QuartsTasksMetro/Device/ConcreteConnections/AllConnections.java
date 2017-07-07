package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Repository.ConexionRepository;

public class AllConnections extends Connection {
	
	private ConexionRepository conexionrepository;
	
	private Connection[] connections= new Connection[conexionrepository.findLastConnection()];

	protected AllConnections(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
	}
	
	@Autowired
	public void setConexionrepository(ConexionRepository conexionrepository){
		this.conexionrepository=conexionrepository;
	}

}
