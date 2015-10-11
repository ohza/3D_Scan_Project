package com.example.threedscan_demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FotoList extends Activity{
	
	private Button neuesFoto;
	private Button start3D;
	private Context listContext;
	private Uri outputFileUri;
	private static int TAKE_PICTURE = 1;
	private ArrayList_Images imList;
	private String TAG = "TEST";
	private MyArrayAdapter adapter;
	private ListView  imListView;
	private static long imageTime;
	private ArrayList<String> imList_names;
	private Context context;
	@Override
	protected void onResume(){
		
		super.onResume();
		
		
		
		if(imList == null){
		imList = new ArrayList_Images();
		}
		
		if(imList_names == null){
			imList_names = new ArrayList_Images();
			}
		
		
	}
	
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotolist);
        context = this.getApplicationContext();
        
        try {
        	MainActivity.outS = ClientThreadService.socket.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        imListView = (ListView) findViewById(R.id.fotolist);
        
        imList = new ArrayList_Images();
        imList_names = new ArrayList<String>();
        
       
        
        listContext = this.getApplicationContext();
        
        neuesFoto =  (Button) findViewById(R.id.neuesfoto);
        start3D =  (Button) findViewById(R.id.threedrec);
        
        
        neuesFoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				
		
				
				
			
				java.util.Date date = new java.util.Date();
				imageTime = date.getTime();
				File file = new File(Environment.getExternalStorageDirectory().getPath(), "Pictures/" + imageTime+".jpg");
				outputFileUri = Uri.fromFile(file);
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
				startActivityForResult(intent, TAKE_PICTURE);
				
				
				
			}
			
		});
        
        
        start3D.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			
				
				try{
				
				
				
				//showPopupMenu2(v);
				
					
					PrintWriter printwriter = new PrintWriter(MainActivity.outS);
					
					printwriter.write("<3DDemo>");
					printwriter.write("<ImAnzahl>" +imList_names.size()  +"</ImAnzahl>");
					
					
					for (int si = 0;si<imList_names.size();si++){
						
					Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath()+"/Pictures/" + imList_names.get(si));
					bitmap = Bitmap.createScaledBitmap (bitmap, 300,400, true);	
						
			       
					
					printwriter.write("<ImBin_"+si+">" +HelperClass.encodeTobase64(bitmap) +"</ImBin_"+si+">");
					printwriter.flush();
					
					}
					
					printwriter.write("</3DDemo>");
					printwriter.flush();
					//printwriter.close();
					
					
					try {
						MainActivity.outS.flush();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					imList = new ArrayList_Images();
					imList_names = new ArrayList<String>();
				
			}   
			
			
			
			catch(Exception e){
				Toast.makeText(context, "Keine Verbindung zum Server", Toast.LENGTH_LONG).show();
			}  
			}    
			
		});
        
        
    }
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == TAKE_PICTURE)
			if(resultCode == RESULT_OK){
				
				
				imList_names.add(imageTime+".jpg");
				
	//			File file = new File(Environment.getExternalStorageDirectory().getPath(),"Pictures/" + imageTime+".jpg");
	//			
	//			Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath()+"/Pictures/" + imageTime+".jpg");
				
			
				Bitmap bitmap_scaled = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath()+"/Pictures/" + imageTime+".jpg"),80,80,true);
				
			   
			    
	//		    try{
//
	//		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//	    bitmap.compress(CompressFormat.JPEG,100, bos);
		//	    byte[] bitmapdata = bos.toByteArray();

	
//			    FileOutputStream fos = new FileOutputStream(file);
//			    fos.write(bitmapdata);
//			    fos.flush();
//			    fos.close();
	//		    }
		//	    catch(Exception e){
			//    	
			  //  }
			  
				imList.add(HelperClass.encodeTobase64(bitmap_scaled));
				
	//			file.delete();
								
				adapter = new MyArrayAdapter(listContext, imList);
				imListView.setAdapter(adapter);
				adapter.setNotifyOnChange(true);
				
				
				
			
				
				
				
				
				
				
				
				
				
				
				
				

		}
	}
	
	
	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void writeToFile(String sFileName, String sBody) {
    	
    	    try
    	    {
    	        File root = new File(Environment.getExternalStorageDirectory(), "note");
    	        if (!root.exists()) {
    	            root.mkdirs();
    	        }
    	        File gpxfile = new File(root, sFileName);
    	        FileWriter writer = new FileWriter(gpxfile);
    	        writer.append(sBody);
    	        writer.flush();
    	        writer.close();
    	        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    	    }
    	    catch(IOException e)
    	    {
    	         e.printStackTrace();
    	        
    	    }
    	   
    }
    
}
