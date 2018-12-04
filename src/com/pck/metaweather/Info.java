package com.pck.metaweather;
import org.json.JSONObject;

public class Info extends Ville{
	
	private String[] temp;
	private String[] windSpeed;
	private String[] humidity;
	
public Info(){
	this.temp= new String[]{"-","-","-","-","-"};
	this.windSpeed= new String[]{"-","-","-","-","-"};
	this.humidity= new String[]{"-","-","-","-","-"};
	
	
}	
	public Info(String nomVille){
		
		try{
		Info l=new Info();
		Ville v=new Ville(nomVille);
		id=v.getId();
		String res=doConnection("https://www.metaweather.com/api/location/"+id);
		for(int i=0; i<5; i++){
			JSONObject obj= new JSONObject(res);
			
			//temperature
			int t =obj.getJSONArray("consolidated_weather").getJSONObject(i).getInt("the_temp");
			l.temp[i]=Integer.toString(t)+"°";
			//wind
			int w=obj.getJSONArray("consolidated_weather").getJSONObject(i).getInt("wind_speed");
			l.windSpeed[i]=Integer.toString(w);
			//humidity
	     	int h =obj.getJSONArray("consolidated_weather").getJSONObject(i).getInt("humidity");
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
	
	public String[] getTemp(){
		return temp;		
	}
	
	public String[] getWind(){
		return windSpeed;		
	}
	public String[] getHumid(){
		return humidity;		
	}
   
}
