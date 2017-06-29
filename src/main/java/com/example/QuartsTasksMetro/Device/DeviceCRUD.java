package com.example.QuartsTasksMetro.Device;

import java.io.UnsupportedEncodingException;
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
		findAllTarjetasAndBuildUserTableForDevice();
	}
	
	private void findAllTarjetasAndBuildUserTableForDevice(){
		List<Tarjeta> tarjetas=	tarjetaRepository.findAll();
		StringBuilder usersBuilder = new StringBuilder();
		String example="Pin=6\tCardNo=3557523742\tPassword=\tStartTime=20170625\tEndTime=20170626\t";
		for (int i = 0; i < tarjetas.size(); i++) {
			
			//System.out.println(tarjetas.get(i).getId()+","+tarjetas.get(i).getCodigoTarjeta()+","+tarjetas.get(i).getUsuario().getNombre());
			}
	}
	
}
