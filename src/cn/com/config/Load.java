package cn.com.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Load {
	private static Properties pop;
	
	static {
		pop = new Properties();
		try {
			pop.load(new FileReader(new File("WEB-INF/config.Properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return pop.getProperty(key);
	}

}
