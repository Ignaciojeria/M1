package com.example.QuartsTasksMetro.Device;

import java.io.UnsupportedEncodingException;

import com.sun.jna.platform.win32.WinNT.HANDLE;

public class DeviceCRUD {

	public void read(HANDLE handle) throws UnsupportedEncodingException{
	int buff=(4*1024*1024);
	byte[] arr= new byte[buff];
	Connection.getTicketingConnection();	
	System.out.println(PullSdk.getPullSdk().GetDeviceData(handle,
			   arr, buff, "userauthorize", "*", "", ""));
	System.out.println(new String(arr,"UTF8").trim());
	}
	
	public void deleteAllRegistersForDevice(HANDLE handle){
		PullSdk.getPullSdk().DeleteDeviceData(handle, "user", "*", "");
		PullSdk.getPullSdk().DeleteDeviceData(handle, "userauthorize", "*", "");
	}
	
	
}
