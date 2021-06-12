package SeleniumWebAutomation;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initateDriver() throws IOException {
		driver = webDriverInitializer();
		log.info("Driver Initiated");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Validated the title successfully");
		
	}
	
	@AfterTest
	public void closeBrowserWindows() {
		driver.close();
		log.info("Browser closed");
	}

}
