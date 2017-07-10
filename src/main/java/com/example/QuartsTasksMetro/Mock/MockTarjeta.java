package com.example.QuartsTasksMetro.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Entity.Usuario;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.UsuarioRepository;

public class MockTarjeta implements ImockCRUD {

	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	
	public MockTarjeta(TarjetaRepository tarjetaRepository){
		this.tarjetaRepository=tarjetaRepository;
	}
	
	public void rellenar(){
		try{
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date initDate = fmt.parse("2013-05-06");
			Date expirationDate =fmt.parse("2500-07-29");
			
			tarjetaRepository.save(new Tarjeta(1,3568056030L,true,initDate,expirationDate,new Usuario("Ignacio","jeria",23,18666636,'4')));
			tarjetaRepository.save(new Tarjeta(2,3557523758L,true,initDate,expirationDate,new Usuario("Ignacio","jeria",23,18666636,'4')));
			tarjetaRepository.save(new Tarjeta(3,3568055934L,true,initDate,expirationDate,new Usuario("Ignacio","jeria",23,18666636,'4')));
			tarjetaRepository.save(new Tarjeta(4,3557519806L,false,initDate,expirationDate,new Usuario("Ignacio","jeria",23,18666636,'4')));
			tarjetaRepository.save(new Tarjeta(5,3560385790L,false,initDate,expirationDate,new Usuario("Ignacio","jeria",23,18666636,'4')));
			
			//Funcionarios METRO
			tarjetaRepository.save(new Tarjeta(6,1856415670L,true,initDate,expirationDate,new Usuario("ARMIN PATRICIO","BARRIENTOS GUARDA",18,13062001,'9')));
			tarjetaRepository.save(new Tarjeta(7,1696663792L,true,initDate,expirationDate,new Usuario("ANDY ALEJANDRO","CORNEJO CORNEJO",18,14205475,'2')));
			tarjetaRepository.save(new Tarjeta(8,2750507809L,true,initDate,expirationDate,new Usuario("MATIAS IVAN","ITURRIETA RAMIREZ",18,10624025,'6')));
			tarjetaRepository.save(new Tarjeta(9,1585724406L,true,initDate,expirationDate,new Usuario("RENIER ALFONSO","CRUZ DIAZ",18,13672262,'K')));
			tarjetaRepository.save(new Tarjeta(10,1651887026L,true,initDate,expirationDate,new Usuario("PATRICIO JAVIER","SILVA VALLE",18,10229321,'5')));
			tarjetaRepository.save(new Tarjeta(11,1935516670L,true,initDate,expirationDate,new Usuario("PAMELA","GONZALEZ GUZMAN",18,17244994,'8')));
		}catch(Exception e){
			
		}

	}
}
