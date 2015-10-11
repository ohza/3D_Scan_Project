package com.example.threedscan_demo;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


	public class MyArrayAdapter extends ArrayAdapter<String> {
		private final Context context;
		
		TextView sampleView;
		ImageView imView;
		
		ArrayList_Images values;
		
		View rowView;
		
		
		

		public MyArrayAdapter(Context context, ArrayList_Images values){
			
			super(context, R.id.fotolist, values);
			
			this.context = context;
			this.values = values;
			
		}
		

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.detail_list, null, true);
			
			
			
			sampleView = (TextView) rowView.findViewById(R.id.label);
			imView = (ImageView) rowView.findViewById(R.id.icon);
			
			
			sampleView.setText("Foto Nr.: "+(position+1));
		
			//imView.setImageBitmap(Bitmap.createScaledBitmap(HelperClass.decodeBase64(values.get(position)),80, 80, true));
			imView.setImageBitmap(HelperClass.decodeBase64(values.get(position)));
			
			;
		
			return rowView;

		}
	} 