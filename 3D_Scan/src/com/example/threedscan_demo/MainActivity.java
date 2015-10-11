package com.example.threedscan_demo;


import java.io.OutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	
	private Button startButton;
	public static OutputStream outS;
	
	@Override
	protected void onResume(){
		super.onResume();
		 startService(new Intent(MainActivity.this,ClientThreadService.class));
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,ClientThreadService.class));
        
        startButton = (Button) findViewById(R.id.startButton);
        
        startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//showPopupMenu2(v);
				
				Intent intent = new Intent(MainActivity.this,FotoList.class);
				startActivity(intent);
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);

		switch(item.getItemId()){
		case(R.id.action_settings)
		
		:{
			showDialog(DIALOG_ALERT);
			return true;
		}
		default: return false;
		}
	}
    
    @Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ALERT:
			// create out AlterDialog
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("3D Scan wirklich beenden?");
			builder.setCancelable(true);
			builder.setPositiveButton("Ja", new OkOnClickListener());
			builder.setNegativeButton("Nein", new CancelOnClickListener());
			AlertDialog dialog = builder.create();
			dialog.show();
		}
		return super.onCreateDialog(id);
	}

	private static final int DIALOG_ALERT = 10;
	private final class CancelOnClickListener implements
	DialogInterface.OnClickListener {
		@Override
		public void onClick(DialogInterface dialog, int which) {
		}
	}

	private final class OkOnClickListener implements
	DialogInterface.OnClickListener {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			finish();
			onDestroy();
		}
	}
}
