package com.example.QuartsTasksMetro.Tasks;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Device.PullSdk;
import com.example.QuartsTasksMetro.Device.ConcreteConnections.ConnectionList;
import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Entity.Transaccion;
import com.example.QuartsTasksMetro.Entity.Usuario;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.sun.jna.platform.win32.WinNT.HANDLE;


public class TransaccionTask implements Job {
	
	
	public static  TransaccionRepository transaccionRepository;
	
	
	public static  TarjetaRepository tarjetaRepository;
	
	//public static byte[] arr = new byte[256];
	//public static HANDLE handle[]= new HANDLE[2];
	public static int id;
	//public static int nextHandle=0;
	//pasar pullSdk Por Referencia.
	//public TransaccionTask(){}
	
	//Singleton de la clase TransaccionTask
	public static TransaccionTask task= new TransaccionTask();

	public TransaccionTask(){}
	
	//Retorno del Singleton
	//singleton al que se le pasan los setters de la inyección de dependencias de de los repositorios de las tarjetas y transacciones.
	public static TransaccionTask getTransaccionTask(TransaccionRepository transaccionRepository,TarjetaRepository tarjetaRepository){
		task.setTransaccionRepository(transaccionRepository);
		task.setTarjetaRepository(tarjetaRepository);
		return task;
	}
	
	@Autowired
	public void setTransaccionRepository(TransaccionRepository transaccion) {
		transaccionRepository = transaccion;	
	}
	
	@Autowired 
	public void setTarjetaRepository(TarjetaRepository tarjeta){
		tarjetaRepository=tarjeta;
	}


	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException, NumberFormatException { 
		//Considerar un blucle for anidado para recorrer los eventos de cada una de las estaciones.
		//donde el indice del handle[0] en el GetRtLog deberá hacer referencia a todas las instancias de
		//conexiones.   ------> NA QUE VER PO CULIAO XDXD
		
		//Lo anterior no tiene sentido por eso lo que debes hacer será pasarle al handle[O] del GertRTLog
		//el nextHandle estatico que creaste por que esto es una tarea programada que se llamará cada cierto
		//tiempo y lo qué tú quieres hacer es llamar diferentes tareas programadas y que esas tareas valga la redundancia
		//se ejecuten referenciando a las diferentes conexiones de las diferentes estaciones.
		for (int i = 0; i <27 ; i++) {
			byte[] arr= ConnectionList.getInstance().getConnections()[0].getArr();
			HANDLE handle=ConnectionList.getInstance().getConnections()[0].getConnectHandle();
		try { 
			
			PullSdk.getPullSdk().GetRTLog(handle, arr, 256);
			//System.out.println(new String (arr,"UTF-8").trim());
			
			if(arr[0]<=0){
				System.out.println("Se ha perdido la conexión de la estación de: "+ ConnectionList.getInstance().getConnections()[0].getStationName());
				ConnectionList.getInstance().getConnections()[0].connect();
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

	}
	
	//Llamar a este método hace referencia a que será una tarea programada con la instancia de conexión que le
	//pasemos por parametro
	public void buildTransaccionTask(HANDLE stationhandle) throws SchedulerException {
	try{
		JobDetail jobdetail= new JobDetail();
		jobdetail.setName("TransaccionTaskDetail");
		jobdetail.setJobClass(TransaccionTask.class);
		
		SimpleTrigger simpletrigger = new SimpleTrigger();
		simpletrigger.setName("Trigger");
		simpletrigger.setStartTime(new Date (System.currentTimeMillis()));
		simpletrigger.setRepeatInterval(10000);
		simpletrigger.setRepeatCount(simpletrigger.REPEAT_INDEFINITELY);
		Scheduler schedulerFactory= new StdSchedulerFactory().getScheduler();
		schedulerFactory.scheduleJob(jobdetail,simpletrigger);
		
		setTransaccionRepository(transaccionRepository);
		setTarjetaRepository(tarjetaRepository);
		schedulerFactory.start();
		
		
	}catch(Exception e){
		System.out.println("xd");
	}
	}
	
//	private void setNextHANDLE(HANDLE handlex){
//		handle[nextHandle]=handlex;
//	}







	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public TransaccionRepository getTransaccionRepository() {
		return transaccionRepository;
	}


	public TarjetaRepository getTarjetaRepository() {
		return tarjetaRepository;
	}
	
	

}
