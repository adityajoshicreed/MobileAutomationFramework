package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driver.DriverGen;

public class BaseClass {
	
	protected WebDriver driver = null;
	
	@BeforeMethod
	@Parameters({"config","serviceType"})
	public void startUp(String config,String serviceType) {
		driver = new DriverGen().generateDriver(serviceType,config);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
