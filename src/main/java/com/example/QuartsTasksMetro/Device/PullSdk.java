package com.example.QuartsTasksMetro.Device;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class PullSdk {
	public interface IPullSdk extends Library {
		 IPullSdk INSTANCE = ( IPullSdk) Native.loadLibrary(
          (Platform.isWindows() ? "plcommpro" : "DllPullSdk"),  IPullSdk.class);
      // it's possible to check the platform on which program runs, for example purposes we assume that there's a linux port of the library (it's not attached to the downloadable project)
		

		 int Connect(String parameters);

		 void Disconnect(HANDLE handle);

		 int SetDeviceParam(HANDLE handle, String values);

		 int ControlDevice(HANDLE connect, long operationId,long param1,
				 long param2,long param3,long param4,
				 String options);

		 int GetRTLog(HANDLE handle,byte[] buffer,int bufferSize);

		 int PullLastError();

		 int ModifyIPAddress(String commtype,String address, String buffer);

		 void NormalPunchOpen();
		 
		 int GetDeviceData(HANDLE handle, byte[] Buffer, int bufferSize, String tableName,String fieldNames,String Filter, String Options);
		 
		 int SetDeviceData(HANDLE handle,String tableName, String data, String options);
		 
		 int DeleteDeviceData(HANDLE handle, String TableName,String Data,String Options);
		 
		 
		 
	}
	
	//Crear 1 singleton por estación
	private static IPullSdk pullsdk=IPullSdk.INSTANCE;
	
	private PullSdk(){
		
	}
	
	public static IPullSdk getPullSdk(){
		return  pullsdk;
	}

}
