package seleniumVOIS.base;



import org.openqa.selenium.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	public static  Logger logger = Logger.getLogger(TestBase.class);

	
	static {
	     properties = ReadProperties("./resources/Properties/configuration.properties");
      } 

	public static Properties ReadProperties(String filePath) {

		try {
			FileInputStream testProperties = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(testProperties);
			return properties;
		} catch (FileNotFoundException e) {
			logger.error("Properties file not found",e);
		} catch (IOException e) {
			logger.error("Properties file error",e);
		}
		return properties;
	}

	public void OpenBrowser() {
		logger = Logger.getLogger("Open browser ");
		String BrowserType = properties.getProperty("browser.type");
		String URL = properties.getProperty("web.url");

		try {

			if (BrowserType.trim().contains("Chrome")) {


				WebDriverManager.chromedriver().setup();

				// Initialize browser
				driver = new ChromeDriver();

				// Open the URL
				logger.info("------------ Opening Browser ------------");
				logger.info("Open URL = " + URL);
				driver.get(URL);
				//driver.manage().window().maximize();
				driver.manage().window().setSize(new Dimension(1024, 768));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		} catch (Exception ex) {
			logger.error("Open browser " + ex.getMessage());
		}

	}

	public static void CloseBrowser() {
		// Close browser
		logger = Logger.getLogger("Close browser ");
		try {
			driver.quit();
			logger.info("Close Browser ...");
		} catch (Exception ex) {
			logger.error("Close browser " + ex.getMessage());

		}

	}
}
