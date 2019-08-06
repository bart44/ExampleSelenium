package objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControls {
	
	public WebDriver driver;
	public DynamicControls(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkBoxSelect = By.xpath("//div[@id='checkbox']//input");
	By removeButton = By.xpath("//button[contains(text(),'Remove')]");
	By enableButton = By.xpath("//button[contains(text(),'Enable')]");
	By inputBox = By.xpath("//form[@id='input-example']//input");
	By inputBoxWait = By.xpath("//form[@id='input-example']//input");	

	
	public WebElement getCheckBoxSelect() throws IOException {
		return driver.findElement(checkBoxSelect);
	}

	public WebElement getRemoveButton() throws IOException {
		return driver.findElement(removeButton);
	}
	
	public WebElement getEnableButton() throws IOException {
		return driver.findElement(enableButton);
	}
	
	public WebElement getInputBox() throws IOException {
		return driver.findElement(inputBox);
	}
	
	public By waitForInputBox() throws IOException {
		return inputBoxWait;
	}
	
}
