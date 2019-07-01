package driver;

import org.openqa.selenium.WebDriver;

import driver.implement.AndroidDriverGen;
import driver.implement.IOSDriver;

public class DriverGen {
	
	private WebDriver driver;
	public WebDriver generateDriver(String type) {
		if(type.equals("Android")) {
			driver = new AndroidDriverGen().genDriver();
		}
		else if(type.equals("IOS")) {
			driver = new IOSDriver().genDriver();
		}
		else {
			return null;
		}
		return driver;
	}
	
}
