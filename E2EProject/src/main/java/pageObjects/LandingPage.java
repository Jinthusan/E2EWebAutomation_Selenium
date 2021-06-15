package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By login = By.cssSelector("a[class*='dropdown-toggle']");
	By title = By.id("learn-what-salesforce-can-do-for-you");
	By navBar = By.cssSelector("ul[class*='searchEnabled'] li");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		
		return driver.findElement(login);
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {

		return driver.findElement(navBar);
	}

}
