
import java.io.File;

import java.io.FileWriter;
import java.util.Scanner;

public class Stemming {

	 public static String stem(String str) {
 
		 LovinsStemmer ls = new LovinsStemmer();
		    if (str.length() <= 2) {
		      return "";
		    }
		    String stemmed = ls.stem(str);
		    while (!stemmed.equals(str)) {
		      str = stemmed;
		      stemmed = ls.stem(stemmed);
		    }
		    return stemmed;
		  }
	 
	
	public static void main (String[] args) {
		
		
		String temp;
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		try
		{
			Scanner sc = new Scanner (inputFile);
			while(sc.hasNext())
			{
				temp=sc.next();	
				temp = stem(temp);
				FileWriter fw = new FileWriter(outputFile, true);
				fw.write(temp + "\n");				
				fw.close();
			}
			
			sc.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.exit(1);			
		}
				
	}
}