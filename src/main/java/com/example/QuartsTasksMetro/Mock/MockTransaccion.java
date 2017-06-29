package com.example.QuartsTasksMetro.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Device.Connection;
import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Entity.Transaccion;
import com.example.QuartsTasksMetro.Entity.Usuario;
import com.example.QuartsTasksMetro.Repository.TransaccionRepository;

public class MockTransaccion implements ImockCRUD {

	@Autowired
	private TransaccionRepository transaccionRepository;
	

	public MockTransaccion(TransaccionRepository transaccionRepository){
		this.transaccionRepository=transaccionRepository;
	}
	
	@Override
	public void rellenar() {
		try{
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fmt.parse("2013-05-06");
			transaccionRepository.save(new Transaccion(date,1,"Test",1,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
			transaccionRepository.save(new Transaccion(date,2,"Test",1,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
			transaccionRepository.save(new Transaccion(date,3,"Test",1,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
			transaccionRepository.save(new Transaccion(date,4,"Test",1,new Tarjeta(1,900,true,date,date,new Usuario("Ignacio",23,18666636,4))));
		}catch(Exception e){
			System.out.println("Error en MockTransaccion");
		}

		
	}

}