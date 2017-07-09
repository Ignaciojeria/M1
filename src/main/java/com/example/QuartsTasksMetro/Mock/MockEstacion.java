package com.example.QuartsTasksMetro.Mock;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Estacion;
import com.example.QuartsTasksMetro.Repository.EstacionRepository;

public class MockEstacion implements ImockCRUD {
	
	@Autowired
	private EstacionRepository estacionRepository;
	
	public MockEstacion(EstacionRepository estacionRepository){
		this.estacionRepository=estacionRepository;
	}

	@Override
	public void rellenar() {
		estacionRepository.save(new Estacion(1,"ticketing","tckt",101));
		estacionRepository.save(new Estacion(2,"testing","test",102));
		
	}

}
