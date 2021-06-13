package resources;
import resources.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver webDriverInitializer() throws IOException {

		 prop = new Properties();// Initialize the data driven object
		// Give file path
		FileInputStream file = new FileInputStream(
				"E:\\SLIIT\\QA Udemy\\Selenium\\Git_E2E_Web_Automation\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(file);// load file into data driven object
		String browserName = prop.getProperty("browser");// derive properties from data.properties

		if (browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\SLIIT\\QA Udemy\\Selenium\\Softwares\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.contains("Firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"E:\\SLIIT\\QA Udemy\\Selenium\\Softwares\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.contains("IE")) {
			System.setProperty("webdriver.ie.driver",
					"E:\\SLIIT\\QA Udemy\\Selenium\\Softwares\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}

}
