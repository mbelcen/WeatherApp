import java.util.Arrays;
import com.pck.url.*;
import com.pck.metaweather.*;
import com.pck.prevision.meteo.*;
import com.pck.transformations.Transformations;
import com.pck.yahoo.*;


public class WeatherForecast extends Connection
{
  public static void main(String[] args) throws Exception
  {	  
	  

   	 
	  String ville=args[0];
	  
	  
	  int argc=Arrays.asList(args).size();
	  
	  //ERROR Control
	  
	  //Nombre de jours
	  if((Arrays.asList(args).contains("-j") && Arrays.asList(args).indexOf("-j")>=argc-1) || !(Arrays.asList(args).contains("-j")) || (isParsable(args[Arrays.asList(args).indexOf("-j")+1])==false) || Integer.parseInt(args[Arrays.asList(args).indexOf("-j")+1])-1 >= 5 || Integer.parseInt(args[Arrays.asList(args).indexOf("-j")+1])-1 < 0){
		  System.out.println("Veuillez entrer -j suivi d'un nombre de jour inférieur à 5 et superieur à 1");
		  System.exit(0);
	  }
	  int indexOfNumberDays= Arrays.asList(args).indexOf("-j")+1;
   	  int numberDays= Integer.parseInt(args[indexOfNumberDays])-1;

	  //Cel/fahr
	  if((Arrays.asList(args).contains("-m")) && ((Arrays.asList(args).indexOf("-m")>=argc-1) || (!(args[Arrays.asList(args).indexOf("-m")+1].equals("C")) &&!(args[Arrays.asList(args).indexOf("-m")+1].equals("F")) ) )){
		  System.out.println("Veuillez entrer -m suivi de C (celsius) ou F (fahr)");
		  System.exit(0);
	  }
	  
	  
	  
	  Info m= new Info(ville);
	  InfoPm p=new InfoPm(ville);
	  InfoYahoo y= new InfoYahoo(ville);
	 
	  Display d=new Display();
	 
	  String[] temp1=m.getTemp();
	  String[] temp2=p.getTempPm();
	  String[] temp3=y.getTempYahoo();
	 
	  String[] wind1=m.getWind();
	  String[] wind2=p.getWindPm();
	  String[] wind3=y.getWindYahoo();
	 
	  String[] humidity1=m.getHumid();
	  String[] humidity2=p.getHumidPm();
	  String[] humidity3=y.getHumidYahoo();
	  
	 
	  String s="+--------------+";
	  for(int i=0;i<=numberDays;i++){
	  	s=d.append(s, "-----+");
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"|              |");
	  for(int i=0;i<=numberDays;i++){
		  	s=d.append(s," J+" +i+ " |");                                                    
		  }
	  s=d.append(s,"\n");
	  s=d.append(s,"+--------------+");
	  for(int i=0;i<=numberDays;i++){
	  	s=d.append(s,"-----+");
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"| MetaWeather  |");
	  
	  Transformations tr=new Transformations();
	  
	  if (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("F")){
		  for(int i=0;i<=numberDays;i++){
			  String substring=temp1[i].substring(0,temp1[i].length()-1);
			  int tt1=tr.celsToFahr(Integer.parseInt(substring));
			  String temp11=Integer.toString(tt1)+"°";
			  String t1=d.ordonner(temp11);
			  s=d.append(s,t1);
			  }
	  }
	  
	  if (!(Arrays.asList(args).contains("-m")) || (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("C"))){
		  for(int i=0;i<=numberDays;i++){
			  String t1=d.ordonner(temp1[i]);
			  s=d.append(s,t1);
			  }
	  }
	  if (Arrays.asList(args).contains("-w")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String w1=d.ordonner(wind1[i]);
			  s=d.append(s,w1);
			  }
	  }
	  if (Arrays.asList(args).contains("-h")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String h1=d.ordonner(humidity1[i]);
			  s=d.append(s,h1);
			  }
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"+--------------+");
	  for(int i=0;i<=numberDays;i++){
	  	s=d.append(s,"-----+");
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"|    P-Méteo   |");
	  if (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("F")){
		  for(int i=0;i<=numberDays;i++){
			  if(!(temp2[i].equals("-"))){
			  String substring=temp2[i].substring(0,temp2[i].length()-1);
			  int tt2=tr.celsToFahr(Integer.parseInt(substring));
			  String temp22=Integer.toString(tt2)+"°";
			  String t2=d.ordonner(temp22);
			  s=d.append(s,t2);
			  }
			  else{
				  String t2=d.ordonner("-");
				  s=d.append(s,t2);
			  }
		  }
	  }
	  
	  if (!(Arrays.asList(args).contains("-m")) || (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("C"))){
		  for(int i=0;i<=numberDays;i++){
			  String t2=d.ordonner(temp2[i]);
			  s=d.append(s,t2);
			  }
	  }
	  if (Arrays.asList(args).contains("-w")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String f=d.ordonner(wind2[i]);
			  s=d.append(s,f);
			  }
	  }
	  if (Arrays.asList(args).contains("-h")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String g=d.ordonner(humidity2[i]);
			  s=d.append(s,g);
			  }
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"+--------------+");
	  for(int i=0;i<=numberDays;i++){
	  	s=d.append(s,"-----+");
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"|     Yahoo    |");
	  if (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("F")){
		  for(int i=0;i<=numberDays;i++){
			  if(!(temp3[i].equals("-"))){
			  String substring=temp3[i].substring(0,temp3[i].length()-1);
			  int tt3=tr.celsToFahr(Integer.parseInt(substring));
			  String temp33=Integer.toString(tt3)+"°";
			  String t3=d.ordonner(temp33);
			  s=d.append(s,t3);
			  }
			  else{
				  String t3=d.ordonner("-");
				  s=d.append(s,t3);
			  }
		  }
	  }
	  
	  if (!(Arrays.asList(args).contains("-m")) || (Arrays.asList(args).contains("-m") && args[Arrays.asList(args).indexOf("-m")+1].equals("C"))){
		  for(int i=0;i<=numberDays;i++){
			  String t3=d.ordonner(temp3[i]);
			  s=d.append(s,t3);
			  }
	  }
	  if (Arrays.asList(args).contains("-w")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String j=d.ordonner(wind3[i]);	
			  s=d.append(s,j);
			  }
	  }
	  if (Arrays.asList(args).contains("-h")){
		  s=d.append(s,"\n");
		  s=d.append(s,"|              |");
		  for(int i=0;i<=numberDays;i++){
			  String k=d.ordonner(humidity3[i]);
			  s=d.append(s,k);
			  }
	  }
	  s=d.append(s,"\n");
	  s=d.append(s,"+--------------+");
	  for(int i=0;i<=numberDays;i++){
	  	s=d.append(s,"-----+");
	  }
	 
	  s=d.append(s,"\n");
	  System.out.println(s);
	  
	  //file writing
	  FileWriting file=new FileWriting();
	  
	  if(Arrays.asList(args).contains("-a")){
		  try{
			  int indexOffileArgument1=Arrays.asList(args).indexOf("-a")+1;		  
			  String path1=args[indexOffileArgument1];
			  file.writing(path1, s);
		  }
		  //in case history text file is not mentioned
		  catch (Exception e) {
				  System.out.println("Erreur de fichier historique: Veuillez entrer -a suivi d'un nom de fichier valide ");

			}
	  }
	  if(Arrays.asList(args).contains("-o")){
		  
		  try{
			  int indexOffileArgument2=Arrays.asList(args).indexOf("-o")+1;
			  String path2=args[indexOffileArgument2];
			  file.overWriting(path2, s);	
		  }
		  //in case history text file is not mentioned
		  catch (Exception e) {
				  System.out.println("Erreur de fichier historique: Veuillez entrer -o suivi d'un nom de fichier valide ");

			}
	  }
	  
	  
  }

  //method to check if a string is parsable that we used to manage errors in the command line
  public static boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}

  
}
