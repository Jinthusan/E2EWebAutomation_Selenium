package SeleniumWebAutomation;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class AssertionNavBar extends Base{
	
	@Test
	public void basePageNavigation() throws IOException {
		
		driver = webDriverInitializer();
		driver.get("http://qaclickacademy.com/");
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		
	}

}
