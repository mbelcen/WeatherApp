package com.pck.url;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

//Class to connect and verify if worked and print it in requetes.log file

public class Connection{
	
	
	public String doConnection(String desiredUrl)
			  throws Exception
			  {
			    URL url = null;
			    BufferedReader reader = null;
			    StringBuilder stringBuilder;
			    try
			    {
			      // create the HttpURLConnection
			      url = new URL(desiredUrl);
			      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			      String message = connection.getResponseMessage();
			       int code = connection.getResponseCode();
			      //use of calendar
			      Calendar now = Calendar.getInstance();
			      //for month we add +1 because months are defined from 0-11
			      String s=now.get(Calendar.DATE) + "-"+now.get(Calendar.MONTH)+1 + "-"+now.get(Calendar.YEAR) + " "+now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)+ ":"+ now.get(Calendar.SECOND);
 
			      //write in the requetes file
			       
			        	
			        	Writer fileWriter = new FileWriter("requetes.log", true);
			    		fileWriter.write(s+" - ["+code+" "+message+"]" +"\n");
			    		fileWriter.write(desiredUrl+"\n");
			    		fileWriter.close();
			        
			        
			      // read the output from the server
			      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			      stringBuilder = new StringBuilder();

			      String line = null;
			      while ((line = reader.readLine()) != null)
			      {
			        stringBuilder.append(line + "\n");
			      }
			      return stringBuilder.toString();
			    }
			    catch (Exception e)
			    {
			      e.printStackTrace();
			      throw e;
			    }
			    finally
			    {
			      // close the reader; this can throw an exception too, so
			      // wrap it in another try/catch block.
			      if (reader != null)
			      {
			        try
			        {
			          reader.close();
			        }
			        catch (IOException ioe)
			        {
			          ioe.printStackTrace();
			        }
			      }
			    }
			  }
	
	

}
