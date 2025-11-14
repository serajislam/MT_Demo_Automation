package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Util extends BaseClass{
	static FileInputStream fis = null;
	static Properties prop;
	
	
	//creating a read property file method or code
		public static String readProperties(String key) throws IOException
		{
			String path = System.getProperty("user.dir")+"/Properties/config.properties";
			Properties prop= new Properties();
			fis=new FileInputStream(path);
			prop.load(fis);
			
			return prop.getProperty(key);
		}
		
		//takeScreenshot code
		/*
		 * public static byte[] takeScreenShot() { return ((TakesScreenshot)
		 * webDriver.get()).getScreenshotAs(OutputType.BYTES);
		 * 
		 * }
		 */
		public static byte[] takeScreenShot() {
	        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	    
	    }
	
	 }
