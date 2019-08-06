package testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class FramesExample extends Base {
	
	public static Logger log = LogManager.getLogger(FramesExample.class.getName());
	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url2"));
		log.info("hit url");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();	
		driver=null;
	}
	
	@Test
	public void frames() throws IOException {			
		//switch to top-frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		log.debug("switched to top-frame");

		//switch to middle-frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		log.debug("switched to middle-frame");

		//switch to default
		driver.switchTo().defaultContent();
		log.debug("switched to defaultContent");
	}

}