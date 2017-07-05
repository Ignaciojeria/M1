package com.example.QuartsTasksMetro.Tasks;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
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
		TransaccionTask transaccionTask= TransaccionTask.getTransaccionTask(transaccionRepository,tarjetaRepository);
		Connection.connectToticketing();
		transaccionTask.setTransaccionRepository(transaccionRepository);
		transaccionTask.setTarjetaRepository(tarjetaRepository);
		//En este punto se arma la tarea programada de monitorización de transacciones de estaciones de metro y se le pasa
		//por parametro la instancia de cada una de las conexiones de las estaciones.
		transaccionTask.buildTransaccionTask(Connection.getTicketingConnection());
	}
}
