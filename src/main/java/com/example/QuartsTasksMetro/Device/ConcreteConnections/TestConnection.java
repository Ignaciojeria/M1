package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import com.example.QuartsTasksMetro.Device.Connection;

public class TestConnection extends Connection {
	
	protected TestConnection(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
		// TODO Auto-generated constructor stub
	}
	private static TestConnection testConnection= new TestConnection("TCP","192.168.0.132","4370","5000","testing");
	
	public static TestConnection getInstance(){
		return testConnection;
	}

}
