package com.example.threedscan_demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




import java.util.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	TextView sampleView;
	TextView sampleDateTime;
	ImageView imView;
	ArrayList_Images values;
	ArrayList<String> mydate;
	
	View rowView;
	public MyArrayAdapter(Context context, ArrayList_Images values, ArrayList<String> mydate){
		super(context, R.id.fotolist, values);
		this.context = context;
		this.values = values;
		this.mydate = mydate;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rowView = inflater.inflate(R.layout.detail_list, null, true);
		sampleView = (TextView) rowView.findViewById(R.id.label);
		sampleDateTime = (TextView) rowView.findViewById(R.id.datetime);
		imView = (ImageView) rowView.findViewById(R.id.icon);
		
		sampleView.setText("Foto No.: "+(position+1));
		sampleDateTime.setText(mydate.get(position));
		
		imView.setImageBitmap(HelperClass.decodeBase64(values.get(position)));
		return rowView;
	}
} 