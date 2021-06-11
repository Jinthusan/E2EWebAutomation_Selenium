package SeleniumWebAutomation;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavBar extends Base{
	
	@BeforeTest
	public void initateDriver() throws IOException {
		driver = webDriverInitializer();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		
	}
	
	@AfterTest
	public void closeBrowserWindows() {
		driver.close();
	}

}
