package seleniumVOIS.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumVOIS.testdata.TestDataReader;
import seleniumVOIS.base.TestBase;
import seleniumVOIS.pages.HomePage;
import seleniumVOIS.pages.RegisterPage;
import seleniumVOIS.pages.SignInPage;

public class UserRegistrationTest extends TestBase
{

	HomePage homepage;
	SignInPage signinpage;
	RegisterPage registerpage;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		OpenBrowser();
		homepage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		registerpage = new RegisterPage(driver);
	}
	
	@DataProvider
	public Object[][] dataProvider_UserCanRegisterSuccssfully() throws InvalidFormatException, IOException {
		Object[][] data = TestDataReader.fetchData(properties.getProperty("TestDataSheetPath"), "UserCanRegisterSuccssfully");
		return data;
	}

	@Test(priority = 1,dataProvider = "dataProvider_UserCanRegisterSuccssfully")
	public void UserCanRegisterSuccssfully(String firstName,String lastName,String password
			,String address,String city,String state,String postCode,String country,String phone
			,String alias)
	{
		logger = Logger.getLogger("UserCanRegister");
        logger.info("<<<Start TestCase UserCanRegisterSuccssfully Test>>>");
		homepage.clickOnSignInLink();
		signinpage.clickonCreateAccount();
		registerpage.register(firstName, lastName, password,address, city, state, postCode, country, phone, alias);
		Assert.assertEquals(homepage.getTextOfLogout(), "Sign out");
        logger.info("<<<End TestCase UserCanRegisterSuccssfully Test>>>");

	}

	@AfterMethod
	public void afterMethod() {
		CloseBrowser();
	}

}
