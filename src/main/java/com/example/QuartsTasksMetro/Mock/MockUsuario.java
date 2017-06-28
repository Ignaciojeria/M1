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
			usuarioRepository.save(new Usuario("Ignacio",23,18666636,4));
			usuarioRepository.save(new Usuario("juanito",18,18666633,2));
	}

}
