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
			Date expirationDate =fmt.parse("29-07-2018");
			
			tarjetaRepository.save(new Tarjeta(1,3568056030L,true,initDate,expirationDate,new Usuario("Ignacio",23,18666636,4)));
			tarjetaRepository.save(new Tarjeta(2,3557523758L,true,initDate,expirationDate,new Usuario("Ignacio",23,18666636,4)));
			tarjetaRepository.save(new Tarjeta(3,3568055934L,true,initDate,expirationDate,new Usuario("Ignacio",23,18666636,4)));
			tarjetaRepository.save(new Tarjeta(4,3557519806L,false,initDate,expirationDate,new Usuario("Ignacio",23,18666636,4)));
			tarjetaRepository.save(new Tarjeta(5,3560385790L,false,initDate,expirationDate,new Usuario("Ignacio",23,18666636,4)));
		}catch(Exception e){
			
		}

	}
}
