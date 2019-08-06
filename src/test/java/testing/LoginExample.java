package testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objects.LoginPage;
import resources.Base;

public class LoginExample extends Base {

	public static Logger log = LogManager.getLogger(LoginExample.class.getName());

	@BeforeTest
	public void initBrowser() throws IOException {
		driver = initDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("hit url");
	}

	@Test(dataProvider = "getData")
	public void login(String Username, String Password) throws IOException {

		// click on sign in and start to login
		LoginPage loginPage = new LoginPage(driver); // YOU NEED TO PASS DRIVER WHEN GIVE LIFE TO OBJECT
		Assert.assertEquals(loginPage.validate().getText(), "Login Page");
		log.info("validated page");
		loginPage.enterLogin().sendKeys(Username);
		loginPage.enterPassword().sendKeys(Password);
		loginPage.signIn().click();
		
		//just to let the test pass and log an error with wrong credentials
		 try {
			 loginPage.logged().isDisplayed();
			 log.info("logged");
		    } catch (NoSuchElementException e) {
		    	log.error("login failed");
		    }
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		// 0th row
		data[0][0] = "login213";
		data[0][1] = "pass123";

		// 1st row
		data[1][0] = "admin";
		data[1][1] = "admin";

		// 2nd row
		data[2][0] = "tomsmith";
		data[2][1] = "SuperSecretPassword!";

		return data;
	}

}
