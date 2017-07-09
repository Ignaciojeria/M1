package com.example.QuartsTasksMetro.Device;

import com.example.QuartsTasksMetro.Exception.AlarmMessageControl;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT.HANDLE;



public class Connection extends Thread{
	private  int count=0;
	private  String protocol="";
	private  String ipaddress="";
	private  String port="";
	private  String timeout="";
	private  String passwd="";
	private  int connectNumber=0;
	private  HANDLE connectHandle=null;
	private  String stationName=""; 
	//public static int nextHandle=0;
	private byte[] arr= new byte[256];

	//este método se encarga de hacer una pantalla del arr con datos harcodeados cuando se pierda la conexión.
	public void gotowash(){
	for (int i = 0; i < arr.length; i++) {
		arr[i]=1;
	}
	}
	private void backTowash(){
		for (int i = 0; i < arr.length; i++) {
			arr[i]=0;
		}
	}
	
	protected Connection(String protocol, String ipaddress,String port, String timeout,String stationName) {
		this.protocol = protocol;
		this.ipaddress = ipaddress;
		this.port=port;
		this.timeout = timeout;
		this.stationName=stationName;
		}
	protected Connection(){}
	
	/*
	private static Connection ticketingConnection= new Connection("TCP","186.10.13.2","4370","5000","ticketing");
	
	private static Connection testConnection= new Connection("TCP","186.10.13.2","4370","5000","ticketing");

	//puedes pasar parametros al retorno del singleton desde este método para que la estación no quede hardcodeada y pueda
	//ser administrable
	
	public static void connectToTestConnection(){
		 testConnection.connect();
	}
	
	public static HANDLE getTestConnection(){
		return testConnection.connectHandle;
	}
	
	public static void connectToticketing(){
		ticketingConnection.connect();
	}
	
	public static HANDLE getTicketingConnection(){
		return ticketingConnection.connectHandle;
		}
		
		*/

	private void setConnectNumber(int connectNumber) throws AlarmMessageControl {
		if (connectNumber!=0) {
			this.connectNumber = connectNumber;
			this.connectHandle=new HANDLE(new Pointer(this.connectNumber));
		}else{
			throw new AlarmMessageControl ("No se ha podido establecer conexión con la estación de "+
											this.stationName+"."+ " Código de error: "+PullSdk.getPullSdk().PullLastError());
		}

	}

	//Tarea Inicial de conectarse con la estación que se realiza de forma recursiva para cada estación hasta lograrse.
	public void connect(){
		backTowash();
		if(this.connectNumber!=0){
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
		//nextHandle++;
		}catch(Exception e){
			System.out.println(e.getMessage());
		//recursividad en caso de que no se establesca bien la conexión con la estación
			if(this.connectNumber==0){
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
		if(this.connectNumber!=0){
			PullSdk.getPullSdk().Disconnect(this.connectHandle);
			System.out.println("Desconectado de "+ stationName);
			this.connectNumber=0;
			this.connectHandle=null;
		}else{
			throw new AlarmMessageControl("No existe conexión actual con cual desconectar de "+stationName);
		}
	}

	public  String getStationName(){
		
		return stationName;
	}


	public HANDLE getConnectHandle() {
		return connectHandle;
	}

	public byte[] getArr() {
		return arr;
	}
	
	private void reestablecer(){
		this.connectHandle=null;
		this.connectNumber=0;
	}

	@Override
	public void run() {
		connect();
	}
	

	
}
