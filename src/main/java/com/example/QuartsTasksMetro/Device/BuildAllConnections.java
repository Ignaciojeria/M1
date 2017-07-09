package com.example.QuartsTasksMetro.Device;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Repository.ConexionRepository;
import com.example.QuartsTasksMetro.Repository.PlacaRepository;

public class BuildAllConnections extends Connection {
	
	@Autowired
	private static ConexionRepository conexionrepository;
	@Autowired
	private static PlacaRepository placarepository;
	
	private static Connection[] connections;
	
	protected BuildAllConnections(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
	}
	public BuildAllConnections(ConexionRepository conexionrepositoryx,PlacaRepository placarepositoryx){
		conexionrepository=conexionrepositoryx;
		placarepository=placarepositoryx;
		connections=new Connection[conexionrepository.findLastConnection()];
	}
	
	public void buildConnections(){
		for (int i = 0; i < connections.length; i++) {
			int z=i+1;
			String protocol=conexionrepository.findById(z).getProtocol();
		    String ipaddress=conexionrepository.findById(z).getIpaddress();
		    String port= conexionrepository.findById(z).getPort();
		    String timeout= conexionrepository.findById(z).getTimeout();
		    String estacion= placarepository.findByConexion(conexionrepository.findById(z)).getEstacion().getNombre();
			System.out.println("Comprobando armado de conexiones["+i+"] protocol: "+protocol
		    +" ipaddress: "+ipaddress+" port: "+port+ " timeout: "+timeout+" estacion: "+estacion);
			connections[i]= new Connection(protocol,ipaddress,port,timeout,estacion);
		//	connections[i]=new Connection();
		//	System.out.println(i);
		}
	}

}
