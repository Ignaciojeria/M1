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
import com.example.QuartsTasksMetro.Mock.MockTarjeta;
import com.example.QuartsTasksMetro.Mock.MockTransaccion;
import com.example.QuartsTasksMetro.Mock.MockUsuario;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.example.QuartsTasksMetro.Repository.UsuarioRepository;
import com.example.QuartsTasksMetro.Tasks.BuildStationTransaccionTask;
import com.example.QuartsTasksMetro.Tasks.TransaccionTask;
import com.sun.jna.platform.win32.WinNT.HANDLE;

@SpringBootApplication
public class QuartsTasksMetroApplication implements CommandLineRunner {
	
	 @Autowired
	 private AlarmaRepository repository;
	 
	 @Autowired
	 private TarjetaRepository tarjetaRepository;
	 
	 @Autowired 
	 private UsuarioRepository usuarioRepository;
	 
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

		MockTarjeta mockTarjeta= new MockTarjeta(tarjetaRepository);
		mockTarjeta.rellenar();
		
		MockUsuario mockUsuario= new MockUsuario(usuarioRepository);
		mockUsuario.rellenar();
		
		MockTransaccion mockTransaccion = new MockTransaccion(transaccionRepository);
		mockTransaccion.rellenar();
		
		BuildStationTransaccionTask buildTransaccionTask= new BuildStationTransaccionTask( transaccionRepository,tarjetaRepository);
		buildTransaccionTask.buildTasks();
		
		DeviceCRUD deviceCrud= new DeviceCRUD(tarjetaRepository);
		deviceCrud.deleteAllRegistersForDevice(Connection.getTicketingConnection());
	//	deviceCrud.readUsers(Connection.getTicketingConnection());
	//	deviceCrud.readUsersAuths(Connection.getTicketingConnection());
		
		//borra todo los registros de la tarjeta.
		deviceCrud.deleteAllRegistersForDevice(Connection.getTicketingConnection());
	
		deviceCrud.SyncDeviceDataWhitDatabaseData(Connection.getTicketingConnection());
		
		//String us="Pin=1\tCardNo=3568056030\tPassword=\tStartTime=20170625\tEndTime=20180626\r\n";
		//String us2=deviceCrud.findAllTarjetasAndBuildUserTableForDevice();
		
		
		//PullSdk.getPullSdk().SetDeviceData(Connection.getTicketingConnection(), "userauthorize", "Pin=1\tAuthorizeTimezoneId=1\tAuthorizeDoorId=15\r\n", "");
		//System.out.println(deviceCrud.findAllTarjetasAndBuildUserTableForDevice());
		deviceCrud.readUsers(Connection.getTicketingConnection());
		deviceCrud.readUsersAuths(Connection.getTicketingConnection());
		
		/*	Connection.connectToticketing();
		 
		
		DeviceCRUD crud= new DeviceCRUD();
		crud.read(Connection.getTicketingConnection());
		
		PullSdk.getPullSdk().SetDeviceData(Connection.getTicketingConnection(), "user", "Pin=6\tCardNo=3568056030\tPassword=\tStartTime=20170625\tEndTime=20180626", "");
		PullSdk.getPullSdk().SetDeviceData(Connection.getTicketingConnection(), "userauthorize", "Pin=6\tAuthorizeTimezoneId=1\tAuthorizeDoorId=15", "");
		
	      */

	      
	} 
	}



