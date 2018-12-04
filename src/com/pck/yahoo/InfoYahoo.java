package com.pck.yahoo;
import org.json.JSONObject;
import com.pck.url.*;
import com.pck.transformations.*;

public class InfoYahoo extends Connection{
	
	private String[] temp;
	private String[] windSpeed;
	private String[] humidity;
	
public InfoYahoo(){
	this.temp= new String[]{"-","-","-","-","-"};
	this.windSpeed= new String[]{"-","-","-","-","-"};
	this.humidity= new String[]{"-","-","-","-","-"};

}
	
public InfoYahoo (String nomVille){
		
		try{
			InfoYahoo l=new InfoYahoo();
			String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+nomVille+"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			String res=doConnection(url);
			
			JSONObject obj= new JSONObject(res);
			Transformations tr=new Transformations();
			//temperature
			int t =obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition").getInt("temp");
			t=tr.fahrToCels(t);
			l.temp[0]=Integer.toString(t)+"°";			
			//wind
			int w=obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("wind").getInt("speed");
			w=tr.mphToKmh(w);
			l.windSpeed[0]=Integer.toString(w);			
			//humidity
	     	int h =obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("atmosphere").getInt("humidity");
	     	l.humidity[0]=Integer.toString(h)+"%";
		
			this.temp=l.temp;
			this.windSpeed=l.windSpeed;
			this.humidity=l.humidity;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

public String[] getTempYahoo(){
	return temp;		
}

public String[] getWindYahoo(){
	return windSpeed;		
}
public String[] getHumidYahoo(){
	return humidity;		
}
}
