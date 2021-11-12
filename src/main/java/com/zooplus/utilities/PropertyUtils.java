package com.zooplus.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	 
	 public static String configProperty(String key) {
		 FileReader reader;
		 Properties property=new Properties();
		try {
			reader = new FileReader("src/main/resources/config/config.properties");
		 property.load(reader); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return property.getProperty(key);
	 }
	 
}
