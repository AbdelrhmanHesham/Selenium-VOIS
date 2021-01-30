package seleniumVOIS.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumVOIS.base.TestBase;
import seleniumVOIS.pages.HomePage;
import seleniumVOIS.pages.SignInPage;

public class LoginTest extends TestBase {

	HomePage homepage;
	SignInPage signinpage;
	String email = properties.getProperty("email");
	String password = properties.getProperty("password");
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		OpenBrowser();
	}


	@Test(priority = 1)
	public void Login()
	{
		logger = Logger.getLogger("Login");
        logger.info("<<<Start TestCase Login Test>>>");
		homepage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		homepage.clickOnSignInLink();
		signinpage.login(email,password);
		Assert.assertEquals(homepage.getTextOfLogout(), "Sign out");
        logger.info("<<<End TestCase Login Test>>>");

	}

	@AfterMethod
	public void afterMethod() {
		CloseBrowser();
	}
}
