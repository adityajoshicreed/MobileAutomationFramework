package driver;

import org.openqa.selenium.WebDriver;

import driver.implement.AndroidDriverGen;
import driver.implement.BrowserStackAndroid;
import driver.implement.IOSDriver;

public class DriverGen {
	
	private WebDriver driver;
	public WebDriver generateDriver(String type,String config) {
		if(type.equals("Android")) {
			driver = new AndroidDriverGen().genDriver(config);
		}
		else if(type.equals("IOS")) {
			driver = new IOSDriver().genDriver(config);
		}
		else if(type.equals("BrowserStackAndroid")) {
			driver = new BrowserStackAndroid().genDriver(config);
		}
		else {
			return null;
		}
		return driver;
	}
	
}
