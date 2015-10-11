package com.example.threedscan_demo;

import java.util.ArrayList;

public class ArrayList_Images extends ArrayList<String> {
	
	private String startTag = "<3DDemo>";
	private String stopTag = "</3DDemo>";
	
	private String imAnzStart = "<ImAnzahl>";
    private String imAnzStop = "</ImAnzahl>";
	
/*	@Override
	public String toString(){
		
		String im = "";
		String im_all = "";
		
		
		
		for(int i=0;i<this.size();i++){
			
			im = "<ImBin_" +i + ">"+this.get(i).toString() + "</ImBin_" +i +">" ;
			im_all += im;
			
		}
		
		return startTag + im_all +  imAnzStart + this.size() + imAnzStop + stopTag;
		
	}
*/
}
