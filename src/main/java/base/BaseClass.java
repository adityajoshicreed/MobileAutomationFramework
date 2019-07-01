package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverGen;

public class BaseClass {
	
	protected WebDriver driver = null;
	
	@BeforeMethod
	public void startUp() {
		driver = new DriverGen().generateDriver("Android");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
