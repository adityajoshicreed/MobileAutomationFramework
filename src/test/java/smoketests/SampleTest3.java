package smoketests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;

public class SampleTest3 extends BaseClass{

	@Test
	public void sampleTest() {
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
	}
	
}
