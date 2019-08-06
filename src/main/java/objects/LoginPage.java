package objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
 
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By login = By.xpath("//input[@id='username']");
	By pass = By.xpath("//input[@id='password']");
	By go = By.xpath("//button[@class='radius']");
	By title = By.xpath("//h2[contains(text(),'Login Page')]");
	By logged = By.xpath("//h2[contains(text(),'Secure Area')]");
	
	public WebElement enterLogin() throws IOException {
		return driver.findElement(login);
	}
	
	public WebElement enterPassword() throws IOException {
		return driver.findElement(pass);
	}
	
	public WebElement signIn() throws IOException {
		return driver.findElement(go); 
	}
	
	public WebElement validate() throws IOException {
		return driver.findElement(title); 
	}
	
	public WebElement logged() throws IOException {
		return driver.findElement(logged); 
	}
	
} 