package SeleniumWebAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavBar extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initateDriver() throws IOException {
		driver = webDriverInitializer();
		log.info("Driver Initiated");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateNavBar() throws IOException {
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Validated the NavBar successfully");
		
	}
	
	@AfterTest
	public void closeBrowserWindows() {
		driver.close();
		log.info("Browser closed");
	}

}
