package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccount extends SeleniumWrappers{
	
	public MyAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ip_email") 
	public WebElement userName;
		
	@FindBy(id = "ip_password") 
	public WebElement userPassword;
	
	@FindBy(xpath="//button [contains(text(), 'Sign in')]")
	public WebElement signIn;
	
	@FindBy(xpath="//span [contains(text(), 'Find jobs')]")
	public WebElement jobsPage;
	
	
	public void loginInApp(String user, String pass) {
		sendKeys(userName, user);
		sendKeys(userPassword, pass);
		click(signIn);
	}
}
