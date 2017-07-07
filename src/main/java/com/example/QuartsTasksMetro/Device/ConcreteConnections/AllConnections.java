package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Repository.ConexionRepository;

public class AllConnections extends Connection {
	
	private static ConexionRepository conexionrepository;
	
	private static Connection[] connections= new Connection[conexionrepository.findLastConnection()];

	protected AllConnections(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
	}
	
	@Autowired
	public void setConexionrepository(ConexionRepository conexionrepositoryx){
		conexionrepository=conexionrepositoryx;
	}
	
	public void buildConnections(){
		for (int i = 0; i < connections.length; i++) {
			String ipaddress=conexionrepository.findbyConnectionId(i).getIpaddress();
			connections[i]=new Connection();
		}
	}

}
