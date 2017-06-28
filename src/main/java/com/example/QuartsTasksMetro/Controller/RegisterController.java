package com.example.QuartsTasksMetro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.UsuarioRepository;

@RestController
public class RegisterController {
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	

}
