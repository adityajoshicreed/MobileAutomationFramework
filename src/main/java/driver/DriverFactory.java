package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {
	
	public abstract WebDriver genDriver(String config);
	public WebDriver driver;

}
