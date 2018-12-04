package com.pck.metaweather;
import org.json.JSONArray;
import com.pck.url.*;

//class to get the id of the desired city to have the right url for information in metaweather

public class Ville extends Connection{
	
	private String url;
	protected int id;
	
	public Ville(){
		url="Unknown";
		id=0;		
	}
	
	public Ville(String nomVille){
		
		url= "https://www.metaweather.com/api/location/search/?query="+nomVille;
		try {
			String results = doConnection(url);
			JSONArray arr = new JSONArray(results);
			id=(int)arr.getJSONObject(0).get("woeid");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getId(){
		return id;
	}
}
	    