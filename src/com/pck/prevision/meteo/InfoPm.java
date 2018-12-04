package com.pck.prevision.meteo;
import org.json.JSONObject;
import com.pck.url.*;

public class InfoPm extends Connection{
	private String[] temp;
	private String[] windSpeed;
	private String[] humidity;
	
public InfoPm(){
	this.temp= new String[]{"-","-","-","-","-"};
	this.windSpeed= new String[]{"-","-","-","-","-"};
	this.humidity= new String[]{"-","-","-","-","-"};

}
public InfoPm(String nomVille){
		
		try{
			InfoPm l=new InfoPm();
			String url="https://www.prevision-meteo.ch/services/json/"+nomVille;
			String res=doConnection(url);
		for(int i=0; i<4; i++){
			JSONObject obj= new JSONObject(res);
			String day="fcst_day_"+i;
			String s=(String) obj.getJSONObject("current_condition").get("hour");
			HourPm hourPm=new HourPm(s,url);
			String hour=hourPm.getHour();
			//temperature
			int t =obj.getJSONObject(day).getJSONObject("hourly_data").getJSONObject(hour).getInt("TMP2m");
			l.temp[i]=Integer.toString(t)+"°";
			//wind
			int w=obj.getJSONObject(day).getJSONObject("hourly_data").getJSONObject(hour).getInt("WNDSPD10m");
			l.windSpeed[i]=Integer.toString(w);
			//humidity
	     	int h =obj.getJSONObject(day).getJSONObject("hourly_data").getJSONObject(hour).getInt("RH2m");
			l.humidity[i]=Integer.toString(h)+"%";

		}
		this.temp=l.temp;
		this.windSpeed=l.windSpeed;
		this.humidity=l.humidity;
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
public String[] getTempPm(){
	return temp;		
}

public String[] getWindPm(){
	return windSpeed;		
}
public String[] getHumidPm(){
	return humidity;		
}
}
