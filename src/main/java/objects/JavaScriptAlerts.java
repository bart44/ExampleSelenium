package objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlerts {
	
	public WebDriver driver;
	public JavaScriptAlerts(WebDriver driver) {
		this.driver = driver;
	}
	
	By jsAlertAcc = By.xpath("//button[contains(text(),'Click for JS Alert')]");
	By jsAlertCancel = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	By jsAlertPrompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	By result = By.xpath("//p[@id='result']");

	public void accept() {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	public void cancel() {
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}
	
	public void write() {
		driver.switchTo().alert().sendKeys("Test213");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	public WebElement jsAlertButton1() throws IOException {
		return driver.findElement(jsAlertAcc);
	}

	public WebElement jsAlertButton2() throws IOException {
		return driver.findElement(jsAlertCancel);
	}
	
	public WebElement jsAlertButton3() throws IOException {
		return driver.findElement(jsAlertPrompt);
	}

	public WebElement getResult() throws IOException {
		return driver.findElement(result);
	}
}
