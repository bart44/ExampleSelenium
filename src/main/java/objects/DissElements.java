package objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DissElements {
	
	public WebDriver driver;
	public DissElements(WebDriver driver) {
		this.driver = driver;
	}
	
	By gallery = By.xpath("//a[contains(text(),'Gallery')]");
	By refresh = By.xpath("//html//body");
	By size = By.tagName("li");
	

	
	public WebElement getGallery() throws IOException {
		return driver.findElement(gallery);
	}

	public WebElement getRefresh() throws IOException {
		return driver.findElement(refresh);
	}
	
	public int getSize() throws IOException {
		return driver.findElements(size).size();
	}
	

}
