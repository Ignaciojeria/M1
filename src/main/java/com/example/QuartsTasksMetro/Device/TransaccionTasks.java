package com.example.QuartsTasksMetro.Device;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.ConcreteConnections.ConnectionListDeprecated;
import com.example.QuartsTasksMetro.Entity.Transaccion;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;
import com.example.QuartsTasksMetro.Repository.PlacaRepository;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class TransaccionTasks extends Thread {

	private byte[] arr;
	private HANDLE handle;
	private Connection connection;
	private static long id;
	private static int connectionId;
	//para registro de transacciones
	private static TransaccionRepository transaccionRepository;
	private static TarjetaRepository tarjetaRepository;
	//fin
	
	//para registro de alarmas
	private static PlacaRepository placaRepository;
	private static AlarmaRepository alarmaRepository;
	
	protected TransaccionTasks(Connection connection){
	connectionId=0;
	this.connection=connection;
	}
	//fin
	
	

	@Autowired
	public static void setTransaccionRepository(TransaccionRepository transaccionRepository) {
		TransaccionTasks.transaccionRepository = transaccionRepository;
	}
	@Autowired
	public static void setTarjetaRepository(TarjetaRepository tarjetaRepository) {
		TransaccionTasks.tarjetaRepository = tarjetaRepository;
	}
	
	@Autowired
	public static void setPlacaRepository(PlacaRepository placaRepository) {
		TransaccionTasks.placaRepository = placaRepository;
	}
	@Autowired
	public static void setAlarmaRepository(AlarmaRepository alarmaRepository) {
		TransaccionTasks.alarmaRepository = alarmaRepository;
	}




	private void InitTransaccionTask(){
		int localConnection=connectionId;
		connectionId++;
		try {
			connection.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		arr=  BuildAllConnections.getConnections()[localConnection].getArr();
		handle=BuildAllConnections.getConnections()[localConnection].getConnectHandle();
		System.out.println(localConnection);
		
		
		while(true){
		//	System.out.println("xd");
		//	System.out.println(BuildAllConnections.getConnections()[localConnection].getConnectHandle());
		//	System.out.println(localConnection);
			for (int i = 0; i < 29; i++) {

			try { 
				
				PullSdk.getPullSdk().GetRTLog(handle, arr, 256);
				//System.out.println(new String (arr,"UTF-8").trim());
				
				if(arr[localConnection]<=0){
					System.out.println("Se ha perdido la conexión de la estación de: "+ BuildAllConnections.getConnections()[localConnection].getStationName());
					BuildAllConnections.getConnections()[localConnection].reestablecer();
					BuildAllConnections.getConnections()[localConnection].connect();
					arr=  BuildAllConnections.getConnections()[localConnection].getArr();
					handle=BuildAllConnections.getConnections()[localConnection].getConnectHandle();
					break;
				}
				String string = new String(arr, "UTF-8");
				//System.out.println(string);
				//System.out.println(handle);
				String[] parts = string.split(",");
				String part1 = parts[0].trim(); // 004
				String part2 = parts[1].trim();
				String part3 = parts[2].trim();
				String part4 = parts[3].trim();
				String part5 = parts[4].trim();
				String part6 = parts[5].trim();
				String part7 = parts[6].trim();
				//part7.replaceAll("\\s", "");
				//System.out.println(part7);
				if (part7.trim().equals("4")) {
					Date fechaTransaccion=null;
					long numeroTarjeta=Long.parseLong(part3);
					int numeroPuerta=Integer.parseInt(part4);
					String estacion= BuildAllConnections.getConnections()[localConnection].getStationName();
					try{
						SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						fechaTransaccion= formato.parse(part1);
					}catch(Exception e){
						System.out.println("Error Al pasar fecha");
					}

					System.out.println("Entro!");
					System.out.println("TIME: " + part1);
					System.out.println("ID: " + part2);
					System.out.println("Card No°: " + part3);
					System.out.println("Door No°: " + part4);
					System.out.println("Event type: " + part5);
					System.out.println("Entry/Exit status: " + part6);
					System.out.println(part7);
					id=transaccionRepository.findLastTransaction();
					id++;	
					
						//transaccionRepository.save(new Transaccion(fechaTransaccion,id,Connection.getStationName(handle),numeroPuerta,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
						if(tarjetaRepository.findByCodigoTarjeta(numeroTarjeta)==null){
							System.out.println("Tarjeta no existe.");
							break;
						}
						
						transaccionRepository.save(new Transaccion(fechaTransaccion,estacion,numeroPuerta,tarjetaRepository.findByCodigoTarjeta(numeroTarjeta)));
					
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			try {
				Thread.sleep( 5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

@Override
public void run(){
	System.out.println("thread transaccionTask");
	InitTransaccionTask();
}

}
		
	/*
		//	for (int index = 0; index < BuildAllConnections.getConnections().length; index++) {
		byte[] arr;
		HANDLE handle;
		int localConnection=connectionId;
		arr=  BuildAllConnections.getConnections()[localConnection].getArr();
		handle=BuildAllConnections.getConnections()[localConnection].getConnectHandle();
		connectionId++;
	//	for (int i = 0; i <27 ; i++) {
		try {
			connection.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
		try { 
			
			PullSdk.getPullSdk().GetRTLog(handle, arr, 256);
			//System.out.println(new String (arr,"UTF-8").trim());
			
			if(arr[localConnection]<=0){
				System.out.println("Se ha perdido la conexión de la estación de: "+ BuildAllConnections.getConnections()[localConnection].getStationName());
				//ConnectionList.getInstance().getConnections()[index].connect();
				return;
			}
			String string = new String(arr, "UTF-8");
			//System.out.println(string);
			//System.out.println(handle);
			String[] parts = string.split(",");
			String part1 = parts[0].trim(); // 004
			String part2 = parts[1].trim();
			String part3 = parts[2].trim();
			String part4 = parts[3].trim();
			String part5 = parts[4].trim();
			String part6 = parts[5].trim();
			String part7 = parts[6].trim();
			//part7.replaceAll("\\s", "");
			//System.out.println(part7);
			if (part7.trim().equals("4")) {
				Date fechaTransaccion=null;
				long numeroTarjeta=Long.parseLong(part3);
				int numeroPuerta=Integer.parseInt(part4);
				try{
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					fechaTransaccion= formato.parse(part1);
				}catch(Exception e){
					System.out.println("Error Al pasar fecha");
				}

				System.out.println("Entro!");
				System.out.println("TIME: " + part1);
				System.out.println("ID: " + part2);
				System.out.println("Card No°: " + part3);
				System.out.println("Door No°: " + part4);
				System.out.println("Event type: " + part5);
				System.out.println("Entry/Exit status: " + part6);
				System.out.println(part7);
				id=transaccionRepository.findLastTransaction();
				id++;	
				
					//transaccionRepository.save(new Transaccion(fechaTransaccion,id,Connection.getStationName(handle),numeroPuerta,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
					if(tarjetaRepository.findByCodigoTarjeta(numeroTarjeta)==null){
						System.out.println("Tarjeta no existe.");
						return;
					}
					
					transaccionRepository.save(new Transaccion(fechaTransaccion,id,"ticketing",numeroPuerta,tarjetaRepository.findByCodigoTarjeta(numeroTarjeta)));
				
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		*/
	
		//}


