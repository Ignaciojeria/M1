package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import com.example.QuartsTasksMetro.Device.Connection;

public class TestConnectionDeprecated extends Connection {
	
	protected TestConnectionDeprecated(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
		// TODO Auto-generated constructor stub
	}
	private static TestConnectionDeprecated testConnection= new TestConnectionDeprecated("TCP","192.168.0.132","4370","5000","testing");
	
	public static TestConnectionDeprecated getInstance(){
		return testConnection;
	}


}
