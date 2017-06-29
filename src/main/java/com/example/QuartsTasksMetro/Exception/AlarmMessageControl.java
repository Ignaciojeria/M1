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
		case -3:
			throw new AlarmMessageControl("Buffer excedido en estación de : "+ estationName+ " código de error: "+errorCode);
		case -4:
			throw new AlarmMessageControl("Fallo en la descompresión : "+ estationName+ " código de error: "+errorCode);
		case -5:
			throw new AlarmMessageControl("La longitud de los datos leídos no es correcta : "+ estationName+ " código de error: "+errorCode);
		case -6:
			throw new AlarmMessageControl("La longitud de los datos descomprimidos de la estación: "+ estationName+" no es consistente con la longitud esperada");
		case -7:
			throw new AlarmMessageControl("Comandos repetidos en estación : "+ estationName+ " código de error: "+errorCode);
		case -8:
			throw new AlarmMessageControl("Conexión no autorizada para estación : "+ estationName+ " código de error: "+errorCode);
		case -9:
			throw new AlarmMessageControl("Error de datos: el resultado del CRC ha fallado en estación de: "+ estationName+ " código de error: "+errorCode);
		case -10:
			throw new AlarmMessageControl("Error de datos: PullSDK no puede resolver los datos en estación de: "+ estationName+ " código de error: "+errorCode);
		case -11:
			throw new AlarmMessageControl("Error en paso de parametros en estación de: "+ estationName+ " código de error: "+errorCode);
		case -12:
			throw new AlarmMessageControl("Comandos de la estación: "+ estationName+ "no se ejecutan correctamente código de error: "+errorCode);
		case -13:
			throw new AlarmMessageControl("Buffer excedido en estación de : "+ estationName+ " código de error: "+errorCode);
		case -14:
			throw new AlarmMessageControl("La contraseña de comunicación no es correcta en estación de : "+ estationName+ " código de error: "+errorCode);
		case -15:
			throw new AlarmMessageControl("Fallo en la escritura de fichero en la estación de : "+ estationName+ " código de error: "+errorCode);
		case -16:
			throw new AlarmMessageControl("Fallo en la lectura de fichero en la estación de  : "+ estationName+ " código de error: "+errorCode);
		case -99:
			throw new AlarmMessageControl("Unknown error estacion: "+estationName+" código de error: "+errorCode);
		case -100:
			throw new AlarmMessageControl("La estructura de tabla no existe en estación: "+estationName+" código de error: "+errorCode);
		case -101:
			throw new AlarmMessageControl("En la estructura de tabla, el campo Condición no existe "+estationName+" código de error: "+errorCode);
		case -102:
			throw new AlarmMessageControl("El número total de atributos en la estación: "+estationName+" no es consistente código de error: "+errorCode);
		case -103:
			throw new AlarmMessageControl("La secuencia de atributos en la estación: "+estationName+" no es consistente código de error: "+errorCode);
		case -104:
			throw new AlarmMessageControl("Error de datos de eventos en tiempo real en la estación: "+estationName+" código de error: "+errorCode);
		case -105:
			throw new AlarmMessageControl("Se producen errores de datos durante la resolución de datos en la estación : "+estationName+" código de error: "+errorCode);
		case -106:
			throw new AlarmMessageControl("Desbordamiento de datos: Los datos entregados tienen más de 4 MB de longitud en estacion de: "+estationName+ " codigo de error: "+errorCode);
		case -107:
			throw new AlarmMessageControl("Error al obtener la estructura de la tabla en la estación "+estationName+ " código de error: "+errorCode);
		case -108:
			throw new AlarmMessageControl("Opciónes invalidas estación: "+estationName+" código de error: "+errorCode);
		case -201:
			throw new AlarmMessageControl("Error en cargar librería de DLLs para estación: "+estationName+" código de error: "+errorCode);
		case -202:
			throw new AlarmMessageControl("Error en la invocación de interface en la estación: "+estationName+" código de error "+errorCode);
		case -203:
			throw new AlarmMessageControl("Inicialización de la comunicación fallida con la estación: "+estationName+" código de error "+errorCode);
		case -206:
			throw new AlarmMessageControl("Start of a serial interface agent program fails and the cause generally relies in inexistence or occupation of the serial interface in: "+estationName+" error code "+errorCode);
		case -301:
			throw new AlarmMessageControl("Requested TCP/IP version error in : "+estationName+ " error code: "+errorCode);
		case -302:
			throw new AlarmMessageControl("Incorrect version number in : "+estationName+ " error code: "+errorCode);
		case -303:
			throw new AlarmMessageControl("Fail to get the protocol type in : "+estationName+ " error code: "+errorCode);
		case -304:
			throw new AlarmMessageControl("Invalid SOCKET in : "+estationName+ " error code: "+errorCode);
		case -305:
			throw new AlarmMessageControl("SOCKET error in : "+estationName+ " error code: "+errorCode);
		case -306:
			throw new AlarmMessageControl("HOST error in : "+estationName+ " error code: "+errorCode);
		case -307:
			throw new AlarmMessageControl("Connection attempt failed in : "+estationName+ " error code: "+errorCode);
		case 10035:
			throw new AlarmMessageControl("Resources temporarily unavailable in : "+estationName+ " error code: "+errorCode);
		case 10038:
			throw new AlarmMessageControl("An operation was attempted on something that is not a socket. in: " +estationName+ " error code: "+errorCode);
		case 10054:
			throw new AlarmMessageControl("Connection reset by peer in: "+estationName+ " error code: "+errorCode);
		case 10060:
			throw new AlarmMessageControl("Connection timed out in: "+estationName+" error code: "+errorCode);
		case 10061:
			throw new AlarmMessageControl("Connection refused in: "+estationName+" error code: "+errorCode);
		case 10062:
			throw new AlarmMessageControl("Connection refused in: "+estationName+" error code: "+errorCode);
		case 10065:
			throw new AlarmMessageControl("No route to host in: "+estationName+" error code: "+errorCode);
		default:
			break;
		}
	
	}
	


}
