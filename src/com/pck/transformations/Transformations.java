package com.pck.transformations;

//class to make unit conversions

public class Transformations {
	private int tempF;
	private int tempC;
	private int speedKpH;
	
	
	//change temperature unit
	public int fahrToCels(float tempInFahr){
		float c = ((tempInFahr - 32)*5)/9;
		tempC = (int) c;
		return tempC;
	}
	public int celsToFahr(float tempInCels){
		float f = 9/5*tempInCels +32;
		tempF = (int) f;
		return tempF;
	}
	//change speed unit
	public int mphToKmh(float speedInMph){
		double s = 1.6093440*speedInMph;
		speedKpH = (int) s;
		return speedKpH;
	}
	
}
