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

	public void readUsersAuths(HANDLE handle) throws UnsupportedEncodingException{
	int buff=(4*1024*1024);
	byte[] arr= new byte[buff];
	Connection.getTicketingConnection();	
	System.out.println(PullSdk.getPullSdk().GetDeviceData(handle,
			   arr, buff, "userauthorize", "*", "", ""));
	System.out.println(new String(arr,"UTF8").trim());
	}
	
	public void readUsers(HANDLE handle) throws UnsupportedEncodingException{
		int buff=(4*1024*1024);
		byte[] arr= new byte[buff];
		Connection.getTicketingConnection();	
		System.out.println(PullSdk.getPullSdk().GetDeviceData(handle,
				   arr, buff, "user", "*", "", ""));
		System.out.println(new String(arr,"UTF8").trim());
	}
	
	public void deleteAllRegistersForDevice(HANDLE handle){
		PullSdk.getPullSdk().DeleteDeviceData(handle, "user", "*", "");
		PullSdk.getPullSdk().DeleteDeviceData(handle, "userauthorize", "*", "");
	}
	
	public void SyncDeviceDataWhitTarjetaDatabaseData(HANDLE handle){
		PullSdk.getPullSdk().SetDeviceData(handle, "user",findAllTarjetasAndBuildUserTableForDevice(), "");
	}
	
	private String findAllTarjetasAndBuildUserTableForDevice(){
		List<Tarjeta> tarjetas=	tarjetaRepository.findAll();
		StringBuilder usersBuilder = new StringBuilder();
	//	String example="Pin=6\tCardNo=3557523742\tPassword=\tStartTime=20170625\tEndTime=20170626\t";
		for (int i = 0; i < tarjetas.size(); i++) {
			
			String localString="Pin="+tarjetas.get(i).getId()+"\t"+
							   "CardNo="+tarjetas.get(i).getCodigoTarjeta()+"\t"+
							   "Password=\t"+
							   "StartTime="+new SimpleDateFormat("yyyyMMdd").format(tarjetas.get(i).getFechaInicial())+"\t"+
							   "EndTime="+new SimpleDateFormat("yyyyMMdd").format(tarjetas.get(i).getFechaExpiracion())+"\r\n";
			usersBuilder.append(localString);
	
			
			}
		return usersBuilder.toString();
	}
	
}
