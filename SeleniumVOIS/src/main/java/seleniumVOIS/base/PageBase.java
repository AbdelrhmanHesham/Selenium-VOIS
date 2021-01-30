package seleniumVOIS.base;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	public static Logger logger = Logger.getLogger(PageBase.class);
    
      WebDriverWait wait;
    
    
    
	public Boolean ElementIsDisplayed(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Check Element is displayed");

		try {
			driver.findElement(element_locator).isDisplayed();
			logger.info(element_log + " is Displayed successfully");
			return true;

		} catch (Exception e) {
			logger.error(element_log + " is not Displayed");
			logger.error(e.getMessage());

			return false;
		}

	}
	
	public void SetElement(WebDriver driver, By element_locator, String value, String element_log) {
		logger = Logger.getLogger("Set Element Text");
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_locator));
		Boolean Flag_element = ElementIsDisplayed(driver, element_locator, element_log);
		try {
			if (Flag_element == true) {
				WebElement element = driver.findElement(element_locator);
				element.clear();
				element.sendKeys(value);
				logger.info("Set " + element_log + " : " + value);
			} else {
				logger.error("Can't Set Element :" + element_log);
			}
		} catch (Exception e) {
			logger.error("Can't Set Element :" + element_log);
		}

	}
	
	public String GetElementText(WebDriver driver, By element_locator, String elementLog) {

		logger =Logger.getLogger("Get Element Text");
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_locator));
		String elementText;

		if (driver.findElement(element_locator).isDisplayed()) {
			elementText = driver.findElement(element_locator).getText();
			logger.info(elementLog + " Actual text is " + elementText);
			return elementText;
		} else {
			logger.error(elementLog + " text is not Displayed");
			return "";
		}

	}
	
	public void ClickElement(WebDriver driver, By element_locator, String element_log) {
		logger =Logger.getLogger("Click Element ");
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element_locator));
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
			logger.info("Click on " + element_log);
		} else {
			logger.error("Cannot Click on " + element_log);
		}
	}

	public void ClickElement_JS(WebDriver driver, By element_locator, String element_log) {
		logger =Logger.getLogger("Click Element");
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element_locator));
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		if (flag == true) {

			WebElement element = driver.findElement(element_locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			logger.info("click on " + element_log);

		} else {
			logger.error("Can't Click on " + element_log);

		}
	}
	
	public void SelectItemFromList(WebDriver driver, By element_locator, String value, String element_log) {
		logger = Logger.getLogger("Select Item from List");
		try {
			Select drpCountry = new Select(driver.findElement(element_locator));
			drpCountry.selectByVisibleText(value);
			logger.info("Select " + element_log + " :  " + value);
		} catch (Exception e) {
			logger.error(" Cannot find element in list with text  : " + value);

		}
	}
	
	
	public void ScrollIntoElementView(WebDriver driver, By element_locator) {
		WebElement element = driver.findElement(element_locator);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	public String randomEmail() {
	        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
	    }

}
