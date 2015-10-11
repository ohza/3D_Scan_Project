package com.example.threedscan_demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

public class HelperClass {
	
	int width;
	int height;
	

	
	

	public static String setImBin(String fName){
		
		FileInputStream fileInputStream=null;

		File file = new File(Environment
				.getExternalStorageDirectory().getPath(),
				"Pictures/" + fName);

		byte[] bFile = new byte[(int) file.length()];

		try {
			//convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return Base64.encodeToString(bFile, Base64.DEFAULT);

	}
	
	
	
	public static String encodeTobase64(Bitmap image)
	{
		//Bitmap immagex=image;
		
		Bitmap immagex = image;
		
		//Bitmap immagex = Bitmap.createScaledBitmap(image,480,640, false);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		byte[] b = baos.toByteArray();
		String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);

		Log.e("LOOK", imageEncoded);
		return imageEncoded;
	}

	public static Bitmap decodeBase64(String input) 
	{
		byte[] decodedByte = Base64.decode(input, 0);
		return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length); 
	}
	
	
	public static String getWithinTags(String matchString,String tag){

		final Pattern pattern = Pattern.compile("<"+tag+">(.+?)</"+tag+">");
		final Matcher matcher = pattern.matcher(matchString);
		try{
		matcher.find();
		return matcher.group(1);
		}
		catch(Exception e){
			System.out.println("An exception has occured within tags: "+e.toString());
			return "";
			
		}
	}
	
	
}
