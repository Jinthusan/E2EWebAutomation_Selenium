package SeleniumWebAutomation;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver = webDriverInitializer();
		driver.get("http://qaclickacademy.com/");
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage lgp = new LoginPage(driver);
		lgp.getUsername().sendKeys(username);
		lgp.getPassword().sendKeys(password);
		//System.out.println(text);
		lgp.getLoginButton().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		//RAW represents the number of types to be run (restrict/non restrict user)
		//Coloumn represents number of values to be pass in a test run
		Object[][] data = new Object[2][2];
		
		//1st user (Restricted)
		data[0][0] = "abc@a.com";
		data[0][1] = "123";
		//data[0][2] = "Restricted User";
		
		//2nd User (Non restricted user)
		data[1][0] = "cde@a.com";
		data[1][1] = "456";
		//data[1][2] = "Non restricted User";
		
		return data;
		
		
	}

}
