package com.example.QuartsTasksMetro.Mock;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Conexion;
import com.example.QuartsTasksMetro.Repository.ConexionRepository;

public class MockConexion implements ImockCRUD {
	
	@Autowired
	private ConexionRepository conexionRepository;
	
	public MockConexion(ConexionRepository conexionRepository){
		this.conexionRepository=conexionRepository;
	}

	@Override
	public void rellenar() {
		conexionRepository.save(new Conexion(2,"TCP","192.168.0.131","4370","4000","a123456"));
		conexionRepository.save(new Conexion(1,"TCP","192.168.0.132","4370","5000","a123456"));
	}

}
