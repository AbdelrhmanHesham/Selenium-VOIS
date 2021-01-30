package seleniumVOIS.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumVOIS.base.PageBase;

public class HomePage extends PageBase {

	
	private WebDriver  driver;
	
	By signInLink = By.xpath("//a[@class='login']");
	By logOutBtn = By.xpath("//a[@class='logout']");

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnSignInLink () 
	{
		ClickElement(driver, signInLink, " SignIn Link");

	}
	
	public void clickOnLogOutBtn () 
	{
		ClickElement(driver, logOutBtn, " Log Out Button");

	}
	
	public String getTextOfLogout() {
		return GetElementText(driver, logOutBtn, "get text 'LogOut'");
	}
	
	

}
