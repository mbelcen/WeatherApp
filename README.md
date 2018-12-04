# WeatherApp

#This as an app developed using OOP in Java.

It extracts weather forecast from MetaWeather, P-Meteo (French), Yahoo REST APIs and displays them on the screen. Temperature (C, F), humidity

All you need to do is run the weather.jar file in a Terminal followed by a location.
Flags: 
-j: number of days wanted
-h: humidity
-m: Fahrenheit F or Celsius C


e.g: $ java -jar weather.jar paris -j 3 -h -m F

 +--------------+-----+-----+-----+
 |              | J+0 | J+1 | J+2 |
 +--------------+-----+-----+-----+
 | MetaWeather  | 38° | 36° | 38° |
 |              | 91% | 85% | 86% |
 +--------------+-----+-----+-----+
 |    P-Méteo   | 37° | 37° | 39° |
 |              | 88% | 87% | 85% |
 +--------------+-----+-----+-----+
 |     Yahoo    | 38° |  -  |  -  |
 |              | 82% |  -  |  -  |
 +--------------+-----+-----+-----+
