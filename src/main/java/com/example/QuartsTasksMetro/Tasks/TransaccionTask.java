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
import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Entity.Transaccion;
import com.example.QuartsTasksMetro.Entity.Usuario;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.sun.jna.platform.win32.WinNT.HANDLE;


public class TransaccionTask implements Job {
	
	
	public static  TransaccionRepository transaccionRepository;
	
	
	public static  TarjetaRepository tarjetaRepository;
	
	public static byte[] arr = new byte[256*50];
	public static HANDLE handle[]= new HANDLE[2];
	public static int id=0;
	//pasar pullSdk Por Referencia.
	//public TransaccionTask(){}
	
	public static TransaccionTask taskTicketing= new TransaccionTask();

	public TransaccionTask(){}
	
	
	public static TransaccionTask getTaskTicketing(TransaccionRepository transaccionRepository,TarjetaRepository tarjetaRepository){
		taskTicketing.setTransaccionRepository(transaccionRepository);
		taskTicketing.setTarjetaRepository(tarjetaRepository);
		return taskTicketing;
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
		for (int i = 0; i <27 ; i++) {
			
		try { 
			PullSdk.getPullSdk().GetRTLog(handle[0], arr, 256);
			//System.out.println(new String (arr,"UTF-8").trim());
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
	
	
	public void buildTransaccionTask() throws SchedulerException{
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
		setHANDLE(handle[0]);
		setTransaccionRepository(transaccionRepository);
		setTarjetaRepository(tarjetaRepository);
		schedulerFactory.start();
	}
	
	public void setHANDLE(HANDLE handlex){
		handle[0]=handlex;
	}


	public byte[] getArr() {
		return arr;
	}


	public void setArr(byte[] arr) {
		this.arr = arr;
	}


	public HANDLE getHandle() {
		return handle[0];
	}


	public void setHandle(HANDLE handlex) {
		handle[0] = handlex;
	}


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
