package com.example.QuartsTasksMetro.Device;

import com.example.QuartsTasksMetro.Exception.AlarmMessageControl;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT.HANDLE;



public class Connection {
	private static int count=0;
	private static String protocol="";
	private static String ipaddress="";
	private static String port="";
	private static String timeout="";
	private static String passwd="";
	private static int connectNumber=0;
	private static HANDLE connectHandle=null;
	//la idea sería crear una clase Station que tenga como atributos el estado de la estación, estado del monitoreo....
	private static String stationName; //luego elimina este atributo y crea la clase estación
	//private PullSdk pullsdk= new PullSdk();
	
	private Connection(String protocol, String ipaddress,String port, String timeout,String stationName) {
		Connection.protocol = protocol;
		Connection.ipaddress = ipaddress;
		Connection.port=port;
		Connection.timeout = timeout;
		Connection.stationName=stationName;
		}
	private static Connection ticketingConnection= new Connection("TCP","186.10.13.2","4370","5000","ticketing");
	
	//puedes pasar parametros al retorno del singleton desde este método para que la estación no quede hardcodeada y pueda
	//ser administrable
	
	public static HANDLE getTicketingConnection(){
		ticketingConnection.connect();
		return connectHandle;
	}

	private void setConnectNumber(int connectNumber) throws AlarmMessageControl {
		if (connectNumber!=0) {
			Connection.connectNumber = connectNumber;
			Connection.connectHandle=new HANDLE(new Pointer(Connection.connectNumber));
		}else{
			throw new AlarmMessageControl ("No se ha podido establecer conexión con la estación de "+
											this.stationName+"."+ " Código de error: "+PullSdk.getPullSdk().PullLastError());
		}

	}

	//Tarea Inicial de conectarse con la estación que se realiza de forma recursiva para cada estación hasta lograrse.
	private void connect(){
		if(Connection.connectNumber!=0){
			System.out.println("Ya existe una conexión con la estación de: "+stationName);
			return;
		}
		try{
		this.setConnectNumber(PullSdk.getPullSdk().Connect("protocol="+protocol+","
				 +"ipaddress="+ipaddress+","
				 +"port="+port+","
				 +"timeout="+timeout+","
				 +"passwd="+passwd));
		System.out.println("Conectado a "+ stationName);
		}catch(Exception e){
			System.out.println(e.getMessage());
		//recursividad en caso de que no se establesca bien la conexión con la estación
			if(Connection.connectNumber==0){
				System.out.println("Reanudando conexión");
				count++;
				if(count==5){
					count=0;
					System.out.println("Para ActiveMQ: Fallo en establecer conexión inicial con: "+stationName);
				}
				connect();
			}
		}
	}
	private void disconnect() throws AlarmMessageControl{
		if(Connection.connectNumber!=0){
			PullSdk.getPullSdk().Disconnect(Connection.connectHandle);
			System.out.println("Desconectado de "+ stationName);
			Connection.connectNumber=0;
			Connection.connectHandle=null;
		}else{
			throw new AlarmMessageControl("No existe conexión actual con cual desconectar de "+stationName);
		}
	}



	private HANDLE getConnectHandle() {
		return connectHandle;
	}
	
}
