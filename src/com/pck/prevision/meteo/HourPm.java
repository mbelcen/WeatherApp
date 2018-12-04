package com.pck.prevision.meteo;

// class to get the current hour and write the right way to access information in Previsions meteo website

public class HourPm {
	
	private String hour;
	
	public HourPm(){
		hour="unknown";
	}
	
	public HourPm(String currentHour, String url){
		try {
			
			//adapt to the format requested
			char chr1=currentHour.charAt(0);
			char chr2=currentHour.charAt(1);
			if (chr1!='0'){
			hour=String.valueOf(chr1)+String.valueOf(chr2)+"H"+"00";
			}
			else{
			hour=String.valueOf(chr2)+"H"+"00";	
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getHour(){
		return hour;
	}
}
