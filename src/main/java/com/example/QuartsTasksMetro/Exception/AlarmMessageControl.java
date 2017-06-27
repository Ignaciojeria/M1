package com.example.QuartsTasksMetro.Exception;

public class AlarmMessageControl extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public AlarmMessageControl(){}
	
	public AlarmMessageControl(String message){
		super(message);
	}
	//el errorCode Proviene del getPullLastError de la instancia del pullSdk De cada estación
	public static void pullLastError(int errorCode, String estationName) throws AlarmMessageControl{
		
		switch (errorCode) {
		case -1:
			throw new AlarmMessageControl("Fallo en envío de comandos de la estación: "+ estationName+ " código de error: "+errorCode);
		case -2:
			throw new AlarmMessageControl("Los comandos de la estación: "+ estationName+" no están respondiendo"+ " código de error: "+errorCode);
		default:
			break;
		}
	}
	


}
