package com.example.QuartsTasksMetro.Device;

public class BuildAllTransaccionTasks {
	
	public BuildAllTransaccionTasks(){}
	
	public void buildAll(){
		
		for (int i = 0; i < BuildAllConnections.getConnections().length; i++) {
			new TransaccionTasks(BuildAllConnections.getConnections()[i]).start();	
		}
	}

}
