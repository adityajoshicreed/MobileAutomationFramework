package driver.implement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.PropertyReader;

public class AndroidDriverGen extends DriverFactory {

	@Override
	public WebDriver genDriver(String config) {
		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			PropertyReader prop = new PropertyReader(config);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automtionName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("version"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			capabilities.setCapability(MobileCapabilityType.UDID, prop.getProperty("udid"));
			capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, prop.getProperty("port"));
			capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("app"));
			capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			driver = new AppiumDriver<MobileElement>(url, capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
