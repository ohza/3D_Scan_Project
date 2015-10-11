package com.example.threedscan_demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



import java.net.InetSocketAddress;
import java.net.Socket;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

public class ClientThreadService extends Service{

	public static boolean timeoutflag;
	public static boolean connectionEstablishedFlag = false;
	
	private static final int SERVERPORT = 4444;
	//private static String SERVER_IP = "104.40.135.218";
	private static String SERVER_IP = "192.168.178.27";
	
	String TAG = "TEST";
	
	InputStream in;
	ByteArrayOutputStream out;
	

	public static Socket socket;
	BufferedReader br;
	TextView tf;
	Context context;
	public static Thread connT;



	@Override
	public void onCreate() {
		super.onCreate();

		context = getBaseContext();
		Log.d(TAG, "SERVICE ON CREATE HAS BEEN CALLED");
		Log.d(TAG, "The connectionEstablishedFlag is: "+connectionEstablishedFlag);

		connT = new Thread(new Runnable() {
			@Override
			public void run() {
				connectToPythonServer();
			}
		});

		connT.start();


	}

	
	public void connectToPythonServer() {



		try {
			
			Log.d(TAG,"Connect to PythonServer has been called");


			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVERPORT),2000);
			timeoutflag = false;
			
			
			if(socket.isConnected()){

				Log.d(TAG,"The socket is connected");

			}

			if(socket.isBound()){

				Log.d(TAG,"The socket is bound");

			}

			if(!socket.isBound()){
				Log.d(TAG,"The socket is not bound");
				timeoutflag = true;
			}

			if(!socket.isConnected()){
				Log.d(TAG,"The socket is not connected");
				timeoutflag = true;
			}

			if(socket.isInputShutdown()){
				Log.d(TAG,"The socket input is shutdown");
				timeoutflag = true;
			}

			if(socket.isOutputShutdown()){
				Log.d(TAG,"The socket output is shutdown");
				timeoutflag = true;
			}


		}

		catch (Exception e) {
			Log.d(TAG,"I have an exception in service..."+e.toString());
			timeoutflag = true;
		}

		try {
			in = new BufferedInputStream(socket.getInputStream());
		} catch (Exception e) {
			timeoutflag = true;
			Log.d(TAG,"I have an IO exection 2..."+e.toString());
		}



		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1];
		int n = 0;
		int k = 0;
		int available = 0;




		try {
			while (-1 != (n = in.read(buf))) {

				if (k == 0) {
					available = in.available();
				}

				out.write(buf, 0, n);
				k++;
				if (k == available + 1) {
					k = 0;
					byte[] response = out.toByteArray();
					String responseString = new String(response);
					if(responseString.equals("<3DDemoSendOK/>")){
						connectionEstablishedFlag = true;
						out.close();
						out.reset();
						
					}
					Log.d(TAG, "The connectionEstablishedFlag is: "+connectionEstablishedFlag);
					
					if (responseString.startsWith("<3DDemo>") && responseString.endsWith("</3DDemo>")) {
						
						Log.d(TAG,"Response String has been received");
						
						serverMessageReceived(responseString);
						
					    out.close();
						out.reset();
						
					}

				}

			}
		} catch (IOException e) {
			Log.d(TAG,"I have an IO exection..."+e.toString());
		}

		catch (NullPointerException e) {
			Log.d(TAG,"I have an Null Pointer exection..."+e.toString());
		}

		catch (Exception e) {
			Log.d(TAG,"I have an whatever exception..."+e.toString());
		}
	}

	public void serverMessageReceived(String responseString){
		
		
		String PLYStatus = HelperClass.getWithinTags(responseString, "PLY_Status");
		
		if(PLYStatus.equals("OK")){
			
			Log.d(TAG,"Ply status is ok");
			
			String PlyString = responseString.substring(45, responseString.length()-20);
			
			byte[] decodedString = Base64.decode(PlyString, Base64.DEFAULT );
			
			Log.d(TAG,PlyString);
			
			
			
			
			
			
			
			/////////////////////////////////////
			FileOutputStream imageOutFile=null;
			  try {
					imageOutFile = new FileOutputStream("/sdcard/Pictures/myply.ply");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        try {
					imageOutFile.write(decodedString);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		   
		        try {
					imageOutFile.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
	
			
			Intent plyView = new Intent(Intent.ACTION_VIEW);
			plyView.setData(Uri.fromFile(new File("/sdcard/Pictures/myply.ply")));
			plyView.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(plyView);
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		else{
			
			Log.d(TAG,"Ply status is not ok");
			
		}
		
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "SERVICE ON BIND HAS BEEN CALLED");
		return null;
	}

	@Override
	public void onStart(Intent intent,int startId){

		Log.d(TAG, "SERVICE ON START HAS BEEN CALLED");


	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "SERVICE ON START COMMAND HAS BEEN CALLED");
		if(!connT.isAlive()){
			Log.d(TAG, "CONNT HAS BEEN RESTARTED");
			onCreate();

		}
		return 0;
	}
	
}

