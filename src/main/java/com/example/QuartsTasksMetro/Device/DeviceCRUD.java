package com.example.QuartsTasksMetro.Device;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.QuartsTasksMetro.Entity.Tarjeta;
import com.example.QuartsTasksMetro.Repository.TarjetaRepository;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class DeviceCRUD {
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	public DeviceCRUD(TarjetaRepository tarjetaRepository){
		this.tarjetaRepository=tarjetaRepository;
	}

	public void readUsersAuths(Connection connection) throws UnsupportedEncodingException{
		
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	int buff=(4*1024*1024);
	byte[] arr= new byte[buff];
	//Connection.getTicketingConnection();	
	System.out.println(PullSdk.getPullSdk().GetDeviceData(connection.getConnectHandle(),
			   arr, buff, "userauthorize", "*", "", ""));
	System.out.println(new String(arr,"UTF8").trim());
	}
	
	
	public void readUsers(Connection connection) throws UnsupportedEncodingException{
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int buff=(4*1024*1024);
		byte[] arr= new byte[buff];
	//	Connection.getTicketingConnection();	
		System.out.println(PullSdk.getPullSdk().GetDeviceData(connection.getConnectHandle(),
				   arr, buff, "user", "*", "", ""));
		System.out.println(new String(arr,"UTF8").trim());
	}
	
	public void deleteAllRegistersForDevice(Connection connection){
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PullSdk.getPullSdk().DeleteDeviceData(connection.getConnectHandle(), "user", "*", "");
		PullSdk.getPullSdk().DeleteDeviceData(connection.getConnectHandle(), "userauthorize", "*", "");
	}
	
	public HANDLE getHandle(Connection connection){
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection.getConnectHandle();
	}
	
	
	public void SyncDeviceDataWhitDatabaseData(Connection connection){	
		try {
			connection.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PullSdk.getPullSdk().SetDeviceData(connection.getConnectHandle(), "user",findAllTarjetasAndBuildUserTableForDevice(), "");
		PullSdk.getPullSdk().SetDeviceData(connection.getConnectHandle(), "userauthorize", FindTarjetasAndBuildUserauthorizeTableForDevice(), "");
	}
	
	private String findAllTarjetasAndBuildUserTableForDevice(){
		List<Tarjeta> tarjetas=	tarjetaRepository.findAll();
		StringBuilder usersBuilder = new StringBuilder();
	//	String example="Pin=6\tCardNo=3557523742\tPassword=\tStartTime=20170625\tEndTime=20170626\t";
		for (int i = 0; i < tarjetas.size(); i++) {
			
			String localString="Pin="+tarjetas.get(i).getId()+"\t"+
							   "CardNo="+tarjetas.get(i).getCodigoTarjeta()+"\t"+
							   "Password=\t"+
							   "SuperAuthorize=1\t"+
							   "StartTime="+new SimpleDateFormat("yyyyMMdd").format(tarjetas.get(i).getFechaInicial())+"\t"+
							   "EndTime="+new SimpleDateFormat("yyyyMMdd").format(tarjetas.get(i).getFechaExpiracion())+"\r\n";
			usersBuilder.append(localString);
			}
		return usersBuilder.toString();
	}
	
	private String FindTarjetasAndBuildUserauthorizeTableForDevice(){
		List<Tarjeta> tarjetas=	tarjetaRepository.findAll();
		StringBuilder usersBuilder = new StringBuilder();
	//	String example="Pin=1\tAuthorizeTimezoneId=1\tAuthorizeDoorId=15\r\n";
		for (int i = 0; i < tarjetas.size(); i++) {
			
			String localString="Pin="+tarjetas.get(i).getId()+"\t"+
							   "AuthorizeTimezoneId=1\t"+
							   "AuthorizeDoorId=15\r\n";
			usersBuilder.append(localString);
			}
		return usersBuilder.toString();
	}
}
