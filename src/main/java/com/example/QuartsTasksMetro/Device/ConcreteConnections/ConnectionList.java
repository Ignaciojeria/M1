package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import java.util.ArrayList;

import com.example.QuartsTasksMetro.Device.Connection;

public class ConnectionList {
	
	private Connection[] connections= new Connection[10];
	
	private static ConnectionList connectionList = new ConnectionList();
	
	private ConnectionList(){
		add();
	}
	public static ConnectionList getInstance(){
		return connectionList;
	}
	
	private void add(){
		connections[0]=TicketingConnection.getInstance();
		connections[1]=TestConnection.getInstance();
	}
	
	public Connection[] getConnections() {
		return connections;
	}
	
}
