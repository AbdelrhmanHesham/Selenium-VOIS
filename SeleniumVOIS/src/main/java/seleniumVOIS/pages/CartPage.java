package seleniumVOIS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import seleniumVOIS.base.PageBase;

public class CartPage extends PageBase{
	
	private WebDriver  driver;
	
	public CartPage(WebDriver driver) {
	this.driver = driver;
}
	
	By womenLink = By.xpath("//a[@title='Women']");
	By blouseLink = By.xpath("//h5//a[@title='Blouse']");
	
	public void clickOnProductLink() {
		ClickElement(driver, womenLink, " women category link");
		ClickElement(driver, blouseLink, " blouse subcategory link");
	}
	
	By productPriceMsg = By.id("our_price_display");
	By productNameMsg = By.xpath("//h1[@itemprop='name']");
	
	public String getTextOfProductPrice()
	{
		return GetElementText(driver, productPriceMsg,"get product price");
	}

	public String getTextOfProductName()
	{
		return GetElementText(driver, productNameMsg,"get product name");
	}
	
	
	By addTOCartBtn = By.xpath("//p[@id='add_to_cart']//button");
	
	public void clickOnAddToCart() throws InterruptedException {
		
		ClickElement(driver, addTOCartBtn, " add to cart Button");

	}
	By confirmAddTOCartMsg = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
	By confirmProductPriceMsg = By.xpath("//span[@class='ajax_block_products_total']");
	By confirmShippingPriceMsg = By.xpath("//span[@class='ajax_cart_shipping_cost']");
	By confirmTotalPriceMsg = By.xpath("//span[@class='ajax_block_cart_total']");

	public String getTextOfConfirmAddTOCart()
	{
		return GetElementText(driver, confirmAddTOCartMsg,"get add to cart confirmation Msg");
	}
	public String getTextOfconfirmProductPrice()
	{
		return GetElementText(driver, confirmProductPriceMsg,"get confirmed product price");
	}
	public String getTextOfConfirmShippingPrice()
	{
		return GetElementText(driver, confirmShippingPriceMsg,"get confirmed shipping price");
	}
	public String getTextOfConfirmTotalPrice()
	{
		return GetElementText(driver, confirmTotalPriceMsg,"get confirmed total price");
	}
	
	
	By proceedToCheckoutBtn = By.xpath("//a[@title='Proceed to checkout']//span");
	
	public void clickOnProceedToCheckout() throws InterruptedException {
		
		ClickElement(driver, proceedToCheckoutBtn, " proceed To Checkout Button");

	}
	
	By summary_ProductPriceMsg=By.xpath("//td[@id='total_product']");
	By summary_TaxPriceMsg=By.xpath("//td[@id='total_tax']");
	By summary_TotalPriceMsg=By.xpath("//span[@id='total_price']");
	By summary_ProductNameMsg=By.xpath("//td[@class='cart_description']//p[@class='product-name']//a");
	
	
	public String getTextOfSummaryProductPrice()
	{
		return GetElementText(driver, summary_ProductPriceMsg,"get summary product price");
	}
	public String getTextOfSummaryTaxPrice()
	{
		return GetElementText(driver, summary_TaxPriceMsg,"get summary tax price");
	}
	public String getTextOfSummaryTotalPrice()
	{
		return GetElementText(driver, summary_TotalPriceMsg,"get summary total price");
	}
	public String getTextOfSummaryProductName()
	{
		return GetElementText(driver, summary_ProductNameMsg,"get summary product name");
	}

	
	By summary_ProceedToCheckoutBtn = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	By address_ProceedToCheckoutBtn = By.name("processAddress");
	
	public void continueToShippingPage () throws InterruptedException {
		
		ClickElement(driver, summary_ProceedToCheckoutBtn, "in summary click on proceed To Checkout Button");
		ClickElement(driver, address_ProceedToCheckoutBtn, "in addres click on proceed To Checkout Button");
	}
	
	
	By shipping_DeliveryPriceMsg=By.xpath("//div[@class='delivery_option_price']");

	public String getTextOfShippingDeliveryPrice()
	{
		return GetElementText(driver, shipping_DeliveryPriceMsg,"get shipping Delivery Price");
	}
	
	By acceptTermsCheck = By.xpath("//p[@class='checkbox']//label");
	By delivery_ProceedToCheckoutBtn = By.name("processCarrier"); 
	
	public void continueToPaymentPage () throws InterruptedException {
		
		ScrollIntoElementView(driver, acceptTermsCheck);
		ClickElement(driver, acceptTermsCheck, "accept terms and conditions");
		ClickElement(driver, delivery_ProceedToCheckoutBtn, "in delivery click on proceed To Checkout Button");
	}
	
	
	By payByBankWireLink = By.xpath("//a[@title='Pay by bank wire']");
	
	public void continueToConfirmationPage () throws InterruptedException {
		
		ClickElement(driver, payByBankWireLink, " pay by bank wire");
	}
	
	By confirm_TotalPriceMsg=By.id("amount");
	By confirm_PaymentMethodMsg=By.xpath("//p[@class='cheque-indent']//strong");
	
	public String getTextOfConfirmedTotalPrice()
	{
		return GetElementText(driver, confirm_TotalPriceMsg,"get confirmed total Price");
	}
	
	public String getTextOfConfirmedPaymentMethod()
	{
		return GetElementText(driver, confirm_PaymentMethodMsg,"get confirmed payment method");
	}
	
	By confirmMyOrderBtn = By.xpath("//button[@class='button btn btn-default button-medium']");
	
	public void confirmOrder () throws InterruptedException {
		
		ClickElement(driver, confirmMyOrderBtn, " confirm order");
	}
	By confirmationSuccessMsg = By.xpath("//p[@class='cheque-indent']//strong");

	public String getTextOfConfirmationSuccessMsg()
	{
		return GetElementText(driver, confirmationSuccessMsg,"get confirmation success");
	}
	
	
	By goToOrderHistoryBtn = By.xpath("//a[@title='Back to orders']");
	
	public void goToOrderHistory() throws InterruptedException {
		
		ClickElement(driver, goToOrderHistoryBtn, " go To Order History");
	}
	
	By goToOrderHistory_ConfirmationMsg = By.xpath("//h1[@class='page-heading bottom-indent']");

	public String getTextOfGoToOrderHistoryMsg()
	{
		return GetElementText(driver, goToOrderHistory_ConfirmationMsg,"get order history confirmation Msg");
	}

	
}
