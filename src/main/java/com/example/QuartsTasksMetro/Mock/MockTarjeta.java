package com.example.QuartsTasksMetro.Mock;

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
		tarjetaRepository.save(new Tarjeta(1,900,true,true,true));
		tarjetaRepository.save(new Tarjeta(2,800,true,true,true));
		tarjetaRepository.save(new Tarjeta(3,700,true,true,true));
	}
}
