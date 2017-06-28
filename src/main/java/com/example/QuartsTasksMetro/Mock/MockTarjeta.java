package com.example.QuartsTasksMetro.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;

public class MockTarjeta implements ImockCRUD {

	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	public MockTarjeta(TarjetaRepository tarjetaRepository){
		this.tarjetaRepository=tarjetaRepository;
	}
	
	public void rellenar(){
		try{
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fmt.parse("2013-05-06");

			tarjetaRepository.save(new Tarjeta(1,900,true,date,date));
			tarjetaRepository.save(new Tarjeta(2,800,true,date,date));
			tarjetaRepository.save(new Tarjeta(3,700,true,date,date));
		}catch(Exception e){
			
		}

	}
}
