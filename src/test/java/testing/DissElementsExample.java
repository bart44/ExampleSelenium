package testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.DissElements;
import resources.Base;

public class DissElementsExample extends Base {

	public static Logger log = LogManager.getLogger(DissElementsExample.class.getName());
	
	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url4"));
		log.info("hit url");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}

	@Test
	public void galleryCheck() throws IOException, InterruptedException {
		DissElements dissElement = new DissElements(driver);

		while (dissElement.getSize() < 5) {
			log.error("refreshing page");
			driver.navigate().refresh();
			log.debug("page refreshed");
		}
		
		Assert.assertTrue(dissElement.getGallery().isDisplayed());
		dissElement.getGallery().click();
		log.info("clicked on gallery");

	}
}
