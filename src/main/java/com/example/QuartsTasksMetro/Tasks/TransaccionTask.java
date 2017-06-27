package com.example.QuartsTasksMetro.Tasks;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
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
import com.example.QuartsTasksMetro.Entity.Transaccion;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;
import com.sun.jna.platform.win32.WinNT.HANDLE;


public class TransaccionTask implements Job {
	
	@Autowired
	private static TransaccionRepository transaccionRepository;
	
	private static byte[] arr = new byte[256];
	private static HANDLE handle;
	private static int id=0;
	//pasar pullSdk Por Referencia.
	//public TransaccionTask(){}

	public TransaccionTask(){
		
	}
	
	



	public void setTransaccionRepository(TransaccionRepository transaccion) {
		transaccionRepository = transaccion;
	}


	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException { 
		
		System.out.println("tarea programada");
		System.out.println(PullSdk.getPullSdk().GetRTLog(handle, arr, 256));
		try {
			System.out.println(new String (arr,"UTF-8").trim());
			String string = new String(arr, "UTF-8");
			System.out.println(string);
			System.out.println(handle);
			String[] parts = string.split(",");
			String part1 = parts[0]; // 004
			String part2 = parts[1];
			String part3 = parts[2];
			String part4 = parts[3];
			String part5 = parts[4];
			String part6 = parts[5];
			String part7 = parts[6];
			//part7.replaceAll("\\s", "");
			System.out.println(part7);
			if (part7.trim().equals("200")) {
				System.out.println("Entro!");
				System.out.println("TIME: " + part1);
				System.out.println("ID: " + part2);
				System.out.println("Card No°: " + part3);
				System.out.println("Door No°: " + part4);
				System.out.println("Event type: " + part5);
				System.out.println("Entry/Exit status: " + part6);
				System.out.println(part7);
				id++;
				transaccionRepository.save(new Transaccion(null,id,900,1,"ticketing"));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*
		

		try {
			// System.out.println(new String (arr,"UTF-8"));
			String string = new String(arr, "UTF-8");
			String[] parts = string.split(",");
			String part1 = parts[0]; // 004
			String part2 = parts[1];
			String part3 = parts[2];
			String part4 = parts[3];
			String part5 = parts[4];
			String part6 = parts[5];
			String part7 = parts[6];
			part7.replaceAll("\\s", "");

			if (((Number) NumberFormat.getInstance().parse(part7)).intValue() == 4) {
				System.out.println("Entro!");
				System.out.println("TIME: " + part1);
				System.out.println("ID: " + part2);
				System.out.println("Card No°: " + part3);
				System.out.println("Door No°: " + part4);
				System.out.println("Event type: " + part5);
				System.out.println("Entry/Exit status: " + part6);
				System.out.println(part7);
				id++;
				transaccionRepository.save(new Transaccion(null,id,900,1,"ticketing"));
			}

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} **/
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
		setHANDLE(handle);
		setTransaccionRepository(transaccionRepository);
		schedulerFactory.start();
	}
	
	public void setHANDLE(HANDLE handlex){
		handle=handlex;
	}

}
