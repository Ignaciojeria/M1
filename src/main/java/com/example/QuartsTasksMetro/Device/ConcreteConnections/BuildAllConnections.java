package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Repository.ConexionRepository;

public class BuildAllConnections extends Connection {
	
	@Autowired
	private static ConexionRepository conexionrepository;
	
	private static Connection[] connections;
	
	protected BuildAllConnections(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
	}
	public BuildAllConnections(ConexionRepository conexionrepositoryx){
		conexionrepository=conexionrepositoryx;
		connections=new Connection[conexionrepository.findLastConnection()];
	}
	
	

	
	public void buildConnections(){
		for (int i = 0; i < connections.length; i++) {
			String ipaddress=conexionrepository.findById(i).getIpaddress();
			System.out.println("Comprobando armado de conexiones["+i+"] "+ipaddress);
		//	connections[i]=new Connection();
		}
	}

}
