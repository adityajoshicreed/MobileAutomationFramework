package driver.implement;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.PropertyReader;

public class BrowserStackAndroid extends DriverFactory {

	public WebDriver driver = null;

	@Override
	public WebDriver genDriver(String config) {
		PropertyReader prop = new PropertyReader(config);
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("device", prop.getProperty("device"));
			caps.setCapability("os_version", prop.getProperty("version"));
			caps.setCapability("name", prop.getProperty("name"));
			caps.setCapability("app", prop.getProperty("app"));
			caps.setCapability("browserstack.debug", prop.getProperty("browserstack.debug"));
			driver = new AndroidDriver<MobileElement>(new URL("https://"+prop.getProperty("user")+":"+prop.getProperty("key")+"@"+prop.getProperty("server")+"/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
