package seleniumVOIS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumVOIS.base.PageBase;

public class RegisterPage extends PageBase {

		
		private WebDriver  driver;
		
		By titleCheck = By.xpath("//input[@id='id_gender1']");
		By firstNameTxt = By.id("customer_firstname");
		By lastNameTxt = By.id("customer_lastname");
		By passwordTxt = By.id("passwd");
		By address_AddressTxt = By.id("address1");
		By address_CityTxt = By.id("city");
		By address_StateSelect = By.name("id_state");
		By address_PostCodeTxt = By.id("postcode");
		By address_CountrySelect = By.name("id_country");
		By address_PhoneTxt = By.id("phone_mobile");
		By address_AliasTxt = By.id("alias");
		By registerBtn = By.id("submitAccount");
		
		
				
		public RegisterPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void register(String firtstName,String lastName,String password,String address_Address
				,String address_City,String address_State,String address_PostCode,String address_Country
				,String address_Phone,String address_Alias) 
		{
		
			ClickElement(driver, titleCheck, " Gender");
			SetElement(driver, firstNameTxt, firtstName, " first name");
			SetElement(driver, lastNameTxt, lastName, " last name");
			SetElement(driver, passwordTxt, password, " password");
			SetElement(driver, address_AddressTxt, address_Address, " address section address");
			SetElement(driver, address_CityTxt, address_City, " address section city");
			SelectItemFromList(driver, address_StateSelect, address_State, " address section state");
			SetElement(driver, address_PostCodeTxt, address_PostCode, " address section postcode");
			SelectItemFromList(driver, address_CountrySelect, address_Country, " address section country");
			SetElement(driver, address_PhoneTxt, address_Phone, " address section phone");
			SetElement(driver, address_AliasTxt, address_Alias, " address section alias");
			ClickElement(driver, registerBtn, " Register Button");

		}
		
}
