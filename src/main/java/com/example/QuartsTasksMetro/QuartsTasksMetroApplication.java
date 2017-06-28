package com.example.QuartsTasksMetro;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.QuartsTasksMetro.Device.DeviceCRUD;
import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Device.PullSdk;
import com.example.QuartsTasksMetro.Entity.Alarma;
import com.example.QuartsTasksMetro.Mock.MockAlarma;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.example.QuartsTasksMetro.Tasks.TransaccionTask;
import com.sun.jna.platform.win32.WinNT.HANDLE;

@SpringBootApplication
public class QuartsTasksMetroApplication implements CommandLineRunner {
	
	 @Autowired
	 private AlarmaRepository repository;
	 
	 @Autowired 
	 private TransaccionRepository transaccionRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(QuartsTasksMetroApplication.class, args);

	}
	//buffer de datos para getDeviceDate


	@Override
	public void run(String... arg0) throws Exception {
	//rellena la tabla Alarma de la base de datos con el mock de alarmas
		//MockAlarma mockAlarma= new MockAlarma(repository);
			//mockAlarma.rellenar();
		//System.out.println(PullSdk.getPullSdk().GetRTLog(connection.getConnectHandle(), new byte[256], 256));
		//----------------------------------------------------------------------------------------------------------

		
		TransaccionTask transaccionTask= new TransaccionTask();
		Connection.connectToticketing();
		transaccionTask.setHANDLE(Connection.getTicketingConnection());
		transaccionTask.setTransaccionRepository(transaccionRepository);
		transaccionTask.buildTransaccionTask();
	
		
		DeviceCRUD crud= new DeviceCRUD();
		crud.read(Connection.getTicketingConnection());
		
		
	/*	Connection.connectToticketing();
		
		DeviceCRUD crud= new DeviceCRUD();
		crud.read(Connection.getTicketingConnection());
		
		PullSdk.getPullSdk().SetDeviceData(Connection.getTicketingConnection(), "user", "Pin=6\tCardNo=3557523742\tPassword=\tStartTime=20170625\tEndTime=20170626", "");
		PullSdk.getPullSdk().SetDeviceData(Connection.getTicketingConnection(), "userauthorize", "Pin=6\tAuthorizeTimezoneId=1\tAuthorizeDoorId=15", "");
		
	      */
		
	      } 
	}



