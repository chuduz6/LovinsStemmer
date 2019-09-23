import java.io.*;
import java.util.*;


public class SingleOne {
	
	public static void main(String[] agrs)
	{
		readWrite("badwordsRefined.txt", "badwordsRefinedSingle.txt");
		
	}
	
	public static void readWrite(String s, String s2)
	{
		String temp;
		String temp2="";
		File inputFile = new File(s);
		File outputFile = new File(s2);
		try
		{
			Scanner sc = new Scanner (inputFile);
			while(sc.hasNextLine())
			{
				temp=sc.nextLine();
				if(!temp.equals(temp2))
				{
				FileWriter fw = new FileWriter(outputFile, true);
				
					fw.write(temp + "\n");
				
				fw.close();			
				
				}
				temp2=temp;
			}
			
			sc.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.exit(1);			
		}
		
	}
	
	
}