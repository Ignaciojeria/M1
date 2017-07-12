package com.example.QuartsTasksMetro.Controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuartsTasksMetro.Device.BuildAllConnections;
import com.example.QuartsTasksMetro.Device.DeviceCRUD;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.example.QuartsTasksMetro.Repository.UsuarioRepository;

@RestController
public class RegisterController {
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@GetMapping(value="readUsers")
	public String readUsers() throws UnsupportedEncodingException{
		return new DeviceCRUD(tarjetaRepository).readUsers(BuildAllConnections.getConnections()[0]);
	}
	
	@GetMapping(value="deleteAllForAllDevices")
	public String deleteAllRegistersForAllDevices() throws UnsupportedEncodingException{
	new DeviceCRUD(tarjetaRepository).deleteAllRegistersForAllDevices();
	return "Has borrado los usuarios y todo registro existente de todos los dispositivos";
	}
	
	@GetMapping(value="SyncAllDevicesWhitDatabaseData")
	public String SyncDeviceDataWhitDatabaseDataForAllDevices() throws UnsupportedEncodingException{
	new DeviceCRUD(tarjetaRepository).SyncDeviceDataWhitDatabaseDataForAllDevices();
	return "Has sincronizado los datos de la base de datos con todo los dispositivos";
	}
	
 
	
	

}
