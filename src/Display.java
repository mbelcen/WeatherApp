//class to organize the display of information and avoid wrong shifts 

public class Display {
	
	private String s;
	
	public String ordonner(String source){
		if(source.length()==1){
			s="  "+source+ "  |";
		}
		else if(source.length()==2){
			s="  "+source+ " |";
		}
		else if(source.length()==3){
			s=" "+source+ " |";
		}
		else{
			s=" "+source+ "|";
		}
		return s;
		
	}
	public String append(String source,String stringToAdd){
		s=source+stringToAdd;
		return s;
	}
	
}
