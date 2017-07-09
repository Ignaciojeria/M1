package com.example.QuartsTasksMetro.Mock;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Conexion;
import com.example.QuartsTasksMetro.Entity.Estacion;
import com.example.QuartsTasksMetro.Entity.Placa;
import com.example.QuartsTasksMetro.Repository.PlacaRepository;

public class MockPlaca implements ImockCRUD {
	
	@Autowired
	private PlacaRepository placaRepository;
	
	public MockPlaca(PlacaRepository placaRepository){
		this.placaRepository=placaRepository;
	}

	@Override
	public void rellenar() {
		placaRepository.save(new Placa(1,true,new Conexion(1,"TCP","192.168.0.131","4370","4000","a123456"),new Estacion(1,"ticketing","tckt",101)));
		placaRepository.save(new Placa(2,true,new Conexion(2,"TCP","192.168.0.132","4370","4000","a123456"),new Estacion(2,"testing","test",102)));
	}

}
