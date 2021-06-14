package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("div[class='text-center'] h2");
	By navBar = By.cssSelector("nav[class*= 'navbar'] li");

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
