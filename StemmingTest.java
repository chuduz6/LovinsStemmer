import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class StemmingTest {

	 public static String stem(String str) {
 
		 LovinsStemmer ls = new LovinsStemmer();
		    if (str.length() <= 2) {
		      return str;
		    }
		    String stemmed = ls.stem(str);
		    while (!stemmed.equals(str)) {
		      str = stemmed;
		      stemmed = ls.stem(stemmed);
		    }
		    return stemmed;
		  }
	 
	
	public static void main (String[] args) throws IOException {
		
		
		StringBuffer input = new StringBuffer();
		Reader reader = null;		
		try {
			reader = new InputStreamReader(new FileInputStream(args[0]));
			reader = new BufferedReader(reader);	
		 	
		int character;
		try {
			while ((character = reader.read()) != -1) 
			{
			    char ch = (char) character;
			    if (Character.isWhitespace((char) ch)) 
			    {
					if (input.length() > 0) 
					{			    
					    try {
					    	String stemmed = stem(input.toString().toLowerCase());
					    	FileWriter fstream = new FileWriter(args[1]);
							  BufferedWriter out = new BufferedWriter(fstream);	
					    	out.write(stemmed);
					    	out.close();
					    	System.out.print( " " + stemmed);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    input.delete(0, input.length());
					}
			    } 
			    else 
			    {
			    	input.append(Character.toLowerCase(ch));
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader.close();
		

				
	}
}