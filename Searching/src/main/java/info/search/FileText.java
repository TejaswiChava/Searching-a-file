package info.search;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class FileText {
	static String numbers="";
	static String line;
	static String s="";
	public static List<String> searching(String text,String path) throws IOException
	{
		List<String> result=new ArrayList<String>();
		
		File folder=new File(path);
		if(folder.isDirectory())
		{
			File[] listofFiles=folder.listFiles();
		
			for(File file:listofFiles)
			{
				if(file.isFile())
				{
					s=file.getCanonicalPath().toString();
					
			
			LineNumberReader lineReader=new LineNumberReader(new FileReader(s));
			while((line=lineReader.readLine())!=null)
			{
			if(line.contains(text))
			{
				result.add("The text exists at"+","+lineReader.getLineNumber()+" in file "+file.getName());
			}
			
			}
			
		}
				
				else if(file.isDirectory())
				{
					result.addAll(searching(text,file.getAbsolutePath()));
		
	} 
		/*
			if(numbers.equals(""))
		return "text not found in any file";*/

	

		}
			
	}
		return result;
	}
		

}
