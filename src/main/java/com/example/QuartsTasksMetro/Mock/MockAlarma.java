package com.example.QuartsTasksMetro.Mock;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Alarma;
import com.example.QuartsTasksMetro.Repository.AlarmaRepository;

public class MockAlarma implements ImockCRUD {
	
	@Autowired
	private AlarmaRepository repository;
	 
	 public MockAlarma(AlarmaRepository repository){
		 
		 this.repository=repository;
	 }

	@Override
	public void rellenar() {
		// TODO Auto-generated method stub
		
	}
	 
	
	 //Agregar Clave foranea que correspondera a la clave de la estación en toda las alarmas.
	/*
	 public void rellenar(){
		 repository.save(new Alarma("The command is not sent successfully",-1,false));
		 repository.save(new Alarma("The command has no response",-2,false));
		 repository.save(new Alarma("The buffer is not enough",-3,false));
		 repository.save(new Alarma("The decompression fails",-4,false));
		 repository.save(new Alarma("The length of the read data is not correct",-5,false));
		 repository.save(new Alarma("The length of the decompressed data is not consistent with the expected length",-6,false));
		 repository.save(new Alarma("The command is repeated",-7,false));
		 repository.save(new Alarma("The connection is not authorized",-8,false));
		 repository.save(new Alarma("Data error: The CRC result is failure",-9,false));
		 repository.save(new Alarma("Data error: PullSDK cannot resolve the data",-10,false));
		 repository.save(new Alarma("Data parameter error ",-11,false));
		 repository.save(new Alarma("The command is not executed correctly",-12,false));
		 repository.save(new Alarma("Command error: This command is not available",-13,false));
		 repository.save(new Alarma("The communication password is not correct",-14,false));
		 repository.save(new Alarma("Fail to write the file",-15,false));
		 repository.save(new Alarma("Fail to read the file",-16,false));
		 repository.save(new Alarma("The file does not exist",-17,false));
		 repository.save(new Alarma("Unknown error ",-99,false));
		 repository.save(new Alarma("The table structure does not exist",-100,false));
		 repository.save(new Alarma("In the table structure, the Condition field does not exit",-101,false));
		 repository.save(new Alarma("The total number of fields is not consistent",-102,false));
		 repository.save(new Alarma("The sequence of fields is not consistent",-103,false));
		 repository.save(new Alarma("Real-time event data error ",-104,false));
		 repository.save(new Alarma("Data errors occur during data resolution",-105,false));
		 repository.save(new Alarma("Data overflow: The delivered data is more than 4 MB in length ",-106,false));
		 repository.save(new Alarma("Fail to get the table structure",-107,false));
		 repository.save(new Alarma("Invalid options",-108,false));
		 repository.save(new Alarma("LoadLibrary failure",-201,false));
		 repository.save(new Alarma("Fail to invoke the interface",-202,false));
		 repository.save(new Alarma("Communication initialization fails ",-203,false));
		 repository.save(new Alarma("Start of a serial interface agent program fails and the cause generally relies in inexistence or occupation of the serial interface. ",-206,false));
		 repository.save(new Alarma("Requested TCP/IP version error",-301,false));
		 repository.save(new Alarma("Incorrect version number ",-302,false));
		 repository.save(new Alarma("Fail to get the protocol type ",-303,false));
		 repository.save(new Alarma("Invalid SOCKET ",-304,false));
		 repository.save(new Alarma("SOCKET error ",-305,false));
		 repository.save(new Alarma("HOST error ",-306,false));
		 repository.save(new Alarma("Connection attempt failed",-307,false));
		 repository.save(new Alarma("Resources temporarily unavailable ",10035,false));
		 repository.save(new Alarma("An operation was attempted on something that is not a socket ",10038,false));
		 repository.save(new Alarma("Connection reset by peer ",10054,false));
		 repository.save(new Alarma("Connection timed out. ",10060,false));
		 repository.save(new Alarma("Connection refused. ",10061,false));
		 repository.save(new Alarma("No route to host. ",10065,false));
	 }
	*/
}
