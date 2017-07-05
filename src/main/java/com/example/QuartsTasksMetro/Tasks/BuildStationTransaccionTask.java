package com.example.QuartsTasksMetro.Tasks;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Device.ConcreteConnections.ConnectionList;
import com.example.QuartsTasksMetro.Device.ConcreteConnections.TestConnection;
import com.example.QuartsTasksMetro.Device.ConcreteConnections.TicketingConnection;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;

public class BuildStationTransaccionTask {
	
	 @Autowired 
	 private static TransaccionRepository transaccionRepository;
	 
	 @Autowired
	 private static TarjetaRepository tarjetaRepository;
	 

	 
	 public BuildStationTransaccionTask(TransaccionRepository transaccionRepositoryx, TarjetaRepository tarjetaRepositoryx){
		 transaccionRepository=transaccionRepositoryx;
		 tarjetaRepository=tarjetaRepositoryx;
	 }

	 
	public void buildTasks() throws SchedulerException{
		//Considerala cómo una transaccion génerica (debes hacer refactoring del método getTaskTicketing).
		TransaccionTask.setRepositoriesTransaccionTasks(transaccionRepository, tarjetaRepository);
		
		TicketingConnection.getInstance().connect();
		TestConnection.getInstance().connect();
		
		TransaccionTask.getTransaccionTask().buildTransaccionTask();
		
		/*
		TestConnection.getInstance().connect();
		TestTask.getTransaccionTask().buildTransaccionTask(TestConnection.getInstance().getConnectHandle(),1);
		*/
		
		/*
		TransaccionTask transaccionTask0=TransaccionTask.getTransaccionTask();
		transaccionTask0.buildTransaccionTask(TicketingConnection.getInstance().getConnectHandle(), 0);
		
		TestConnection.getInstance().connect();
		transaccionTask0.buildTransaccionTask(TestConnection.getInstance().getConnectHandle(),1);
		
		TransaccionTask transaccionTask1=TransaccionTask.getTransaccionTask();
		*/
		

		//TicketingConnection.getInstance().connect();
		//transaccionTask0.buildTransaccionTask(TicketingConnection.getInstance().getConnectHandle(),0);
		
		//En este punto se arma la tarea programada de monitorización de transacciones de estaciones de metro y se le pasa
		//por parametro la instancia de cada una de las conexiones de las estaciones. , IMPORTANTE!! int index
		
		
	//	TestConnection.getInstance().connect();
		
		
	//	TransaccionTask transaccionTask1= TransaccionTask.getTransaccionTask1();
		
		
	//	transaccionTask1.buildTransaccionTask(TestConnection.getInstance().getConnectHandle(),1);
	}
}
