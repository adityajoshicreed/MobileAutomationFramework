package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private FileInputStream fis = null;
	private Properties p = null;

	public PropertyReader(String path) {
		try {
			fis = new FileInputStream(
					getClass().getClassLoader().getResource(path).getFile());
			p = new Properties();
			p.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String property) {
		return p.getProperty(property);
	}

}
