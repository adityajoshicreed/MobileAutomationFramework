package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private FileInputStream fis = null;

	public String getProperty(String property) {
		try {
			fis = new FileInputStream(
					getClass().getClassLoader().getResource("DriverConf/Android.properties").getFile());
			Properties p = new Properties();
			p.load(fis);
			fis.close();
			return p.getProperty(property);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
