package seleniumVOIS.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumVOIS.base.TestBase;
import seleniumVOIS.pages.CartPage;
import seleniumVOIS.testdata.TestDataReader;

public class CartCheckOutTest extends TestBase {

	CartPage cartpage;

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		OpenBrowser();
		LoginTest loginObj = new LoginTest();
		loginObj.Login();
		cartpage = new CartPage(driver);
		
	}

	@DataProvider
	public Object[][] dataProvider_CheckOutTheCard() throws InvalidFormatException, IOException {
		Object[][] data = TestDataReader.fetchData(properties.getProperty("TestDataSheetPath"), "CheckOutTheCard");
		return data;
	}

	@Test(priority = 1,dataProvider = "dataProvider_CheckOutTheCard")
	public void CheckOutTheCard(String productPrice,String productName,String addToCartConfirmedMsg,String ConfirmShippingPrice,
			String ConfirmTotalPrice,String SummaryTaxPrice,String SummaryTotalPrice,String ShippingDeliveryPrice,
			String ConfirmedPaymentMethod,String ConfirmationSuccessMsg,String GoToOrderHistoryMsg) throws InterruptedException
	{
		logger = Logger.getLogger("CheckOutTheCard");
        logger.info("<<<Start TestCase CheckOutTheCard Test>>>");
		cartpage.clickOnProductLink();
		Assert.assertEquals(cartpage.getTextOfProductPrice(), productPrice);
		Assert.assertEquals(cartpage.getTextOfProductName(), productName);

		cartpage.clickOnAddToCart();
		Assert.assertEquals(cartpage.getTextOfConfirmAddTOCart(),addToCartConfirmedMsg);
		Assert.assertEquals(cartpage.getTextOfconfirmProductPrice(), productPrice);
		Assert.assertEquals(cartpage.getTextOfConfirmShippingPrice(), ConfirmShippingPrice);
		Assert.assertEquals(cartpage.getTextOfConfirmTotalPrice(), ConfirmTotalPrice);
		
		
		cartpage.clickOnProceedToCheckout();
		Assert.assertEquals(cartpage.getTextOfSummaryProductPrice(), productPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryTaxPrice(), SummaryTaxPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryTotalPrice(), SummaryTotalPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryProductName(), productName);
		
		
		
		cartpage.continueToShippingPage();
		Assert.assertEquals(cartpage.getTextOfShippingDeliveryPrice(),ShippingDeliveryPrice);

		cartpage.continueToPaymentPage();
		Assert.assertEquals(cartpage.getTextOfSummaryProductPrice(), productPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryTaxPrice(), SummaryTaxPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryTotalPrice(), SummaryTotalPrice);
		Assert.assertEquals(cartpage.getTextOfSummaryProductName(), productName);
		
		cartpage.continueToConfirmationPage();
		Assert.assertEquals(cartpage.getTextOfConfirmedTotalPrice(), SummaryTotalPrice);
		Assert.assertTrue(cartpage.getTextOfConfirmedPaymentMethod().contains(ConfirmedPaymentMethod));

		cartpage.confirmOrder();
		Assert.assertEquals(cartpage.getTextOfConfirmationSuccessMsg(), ConfirmationSuccessMsg);
		
		cartpage.goToOrderHistory();
		Assert.assertEquals(cartpage.getTextOfGoToOrderHistoryMsg(), GoToOrderHistoryMsg);

        logger.info("<<<End TestCase CheckOutTheCard Test>>>");

	}

	@AfterMethod
	public void afterMethod() {
		CloseBrowser();
	}
}
