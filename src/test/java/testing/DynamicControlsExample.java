package testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.DynamicControls;
import resources.Base;

public class DynamicControlsExample extends Base {
	
	public static Logger log = LogManager.getLogger(DynamicControlsExample.class.getName());
	
	@BeforeTest
	public void initBrowser() throws IOException, InterruptedException {
		driver = initDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url3"));
		log.info("hit url");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();	
		driver=null;
	}
	
	@Test
	public void dynamicControls() throws IOException, InterruptedException {			

		DynamicControls dynamicControls = new DynamicControls(driver);
		
		dynamicControls.getCheckBoxSelect().click();
		Assert.assertTrue(dynamicControls.getCheckBoxSelect().isSelected());
		log.info("chceckbox validated as selected");
		
		dynamicControls.getRemoveButton().click();
		dynamicControls.getEnableButton().click();
		log.info("wait for WebElements");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dynamicControls.getInputBox()));
		log.debug("InputBox is visible now");
		
		dynamicControls.getInputBox().sendKeys("Test");
		log.info("typed Test into inputBox");
	}
	

	
}
