package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Utility {
	
	InputStream iS=null;
	/**
	 * This method is responsible to read the data from properties file
	 * @author Sanjaya
	 * @throws IOException 
	 * @key: unique key of the properties file
	 * @propertiesFileName: file name 
	 * 
	 */
	
	public String readProperty(String key,String propertiesFileName) {
		
		Properties prop=new Properties();
		try {
			iS=new FileInputStream(new File("src//test//resources//"+propertiesFileName+".properties"));
			
			prop.load(iS);
		}catch(IOException ie) {
			System.out.println("File Not Found");
		}
		return prop.getProperty(key);
		
	}
}
