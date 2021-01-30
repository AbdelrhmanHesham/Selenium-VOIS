package seleniumVOIS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumVOIS.base.PageBase;

public class SignInPage extends PageBase {

	private WebDriver  driver;
	
	By createAccount_EmailTxt = By.id("email_create");
	By createAccount_CreateAccountBtn= By.id("SubmitCreate");

	By login_EmailTxt = By.id("email");
	By login_PasswordTxt = By.id("passwd");
	By login_SignInBtn = By.id("SubmitLogin");

	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickonCreateAccount() {
		
		SetElement(driver, createAccount_EmailTxt, randomEmail(), " Email");
		ClickElement(driver, createAccount_CreateAccountBtn, " Create An Account");
	}
	
	public void login(String email,String password) {
		
		SetElement(driver, login_EmailTxt, email, " Email");
		SetElement(driver, login_PasswordTxt, password, " Password");
		ClickElement(driver, login_SignInBtn, " Sign In");
	}
}