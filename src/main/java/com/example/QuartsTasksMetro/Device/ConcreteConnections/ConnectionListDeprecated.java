package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import java.util.ArrayList;

import com.example.QuartsTasksMetro.Device.Connection;

public class ConnectionListDeprecated {
	
	private Connection[] connections= new Connection[2];
	
	private static ConnectionListDeprecated connectionList = new ConnectionListDeprecated();
	
	private ConnectionListDeprecated(){
		add();
	}
	public static ConnectionListDeprecated getInstance(){
		return connectionList;
	}
	
	private void add(){
		connections[0]=TicketingConnectionDeprecated.getInstance();
		connections[1]=TestConnectionDeprecated.getInstance();
	}
	
	public Connection[] getConnections() {
		return connections;
	}
	
}
