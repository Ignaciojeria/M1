package com.example.QuartsTasksMetro.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Entity.Usuario;
import com.example.QuartsTasksMetro.Repository.UsuarioRepository;

public class MockUsuario implements ImockCRUD {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public MockUsuario(UsuarioRepository usuarioRepository){
	this.usuarioRepository=	usuarioRepository;
	}
	
	@Override
	public void rellenar() {
		// TODO Auto-generated method stub
			usuarioRepository.save(new Usuario("Ignacio","Jeria",23,18666636,'4'));
			usuarioRepository.save(new Usuario("juanito","perez",18,18666633,'2'));
			//Funcionarios METRO
			usuarioRepository.save(new Usuario("ARMIN PATRICIO","BARRIENTOS GUARDA",18,13062001,'9'));
			usuarioRepository.save(new Usuario("ANDY ALEJANDRO","CORNEJO CORNEJO",18,14205475,'2'));
			usuarioRepository.save(new Usuario("MATIAS IVAN","ITURRIETA RAMIREZ",18,10624025,'6'));
			usuarioRepository.save(new Usuario("RENIER ALFONSO","CRUZ DIAZ",18,13672262,'K'));
			usuarioRepository.save(new Usuario("PATRICIO JAVIER","SILVA VALLE",18,10229321,'5'));
			usuarioRepository.save(new Usuario("PAMELA","GONZALEZ GUZMAN",18,17244994,'8'));
	}

}
