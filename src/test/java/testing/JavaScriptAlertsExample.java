package testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.JavaScriptAlerts;
import resources.Base;

public class JavaScriptAlertsExample extends Base {
	
	public static Logger log = LogManager.getLogger(JavaScriptAlertsExample.class.getName());
	
	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url5"));
		log.info("hit url5");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
	
	@Test
	public void javaScriptAlerts() throws IOException, InterruptedException {
		JavaScriptAlerts alert = new JavaScriptAlerts(driver);
		alert.jsAlertButton1().click();
		alert.accept();
		Assert.assertEquals(alert.getResult().getText(), "You successfuly clicked an alert");
		
		alert.jsAlertButton2().click();
		alert.cancel();
		Assert.assertEquals(alert.getResult().getText(), "You clicked: Cancel");
		
		alert.jsAlertButton3().click();
		alert.write();
		Assert.assertEquals(alert.getResult().getText(), "You entered: Test213");
		
	}

}
