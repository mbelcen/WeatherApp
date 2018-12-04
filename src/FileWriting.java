import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;

// class to write in a file
public class FileWriting {
	
	public void writing(String path,String s) throws IOException{
		Writer fileWriter = new FileWriter(path, true);
		fileWriter.write(s);
		fileWriter.close();
	}
	public void overWriting(String path,String s) throws IOException{
		Writer fileWriter = new FileWriter(path, false);
		fileWriter.write(s);
		fileWriter.close();
	}
}
