package com.example.QuartsTasksMetro.Device.ConcreteConnections;

import com.example.QuartsTasksMetro.Device.Connection;

public class TicketingConnectionDeprecated extends Connection {

	protected TicketingConnectionDeprecated(String protocol, String ipaddress, String port, String timeout, String stationName) {
		super(protocol, ipaddress, port, timeout, stationName);
	}
	//ip pública
	//private static TicketingConnection ticketingconnection= new TicketingConnection("TCP","186.10.13.2","4370","5000","ticketing");
	private static TicketingConnectionDeprecated ticketingconnection= new TicketingConnectionDeprecated("TCP","192.168.0.131","4370","4000","ticketing");
	
	public static TicketingConnectionDeprecated getInstance(){
		return ticketingconnection;
	}



}
