package pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class CompaniesPage extends SeleniumWrappers{
	public CompaniesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="company_filter_search") 
	public WebElement companySearch;	
	
	@FindBy(xpath="//a[contains(text(), 'CoinTracker')]")
	public WebElement coinTracker;
	 
	@FindBy(xpath="//a[@data-company-id='2059']")
	public WebElement followButton;
	 
	@FindBy(xpath="//a[@href='https://www.cointracker.io']")
	public WebElement visitWebsite;
	
	@FindBy(xpath="//a [contains(text(), 'Send message')]")
	public WebElement sendMessage;
	
	@FindBy(xpath="//a [contains(text(), 'Log in')]")
	public WebElement loginPopUp;
	
	@FindBy(xpath="//i[@class='la la-times large']")
	public WebElement closePopUp;
	
	@FindBy(xpath="//div[@class='list-cate']/a[@href='https://moony.ro/company-categories/b2b-saas/']")
	public WebElement b2bCategory;
	 
	@FindBy(xpath="//div[@class='list-cate']/a[@href='https://moony.ro/company-categories/web-development/']")
	public WebElement webCategory;
	
	@FindBy(xpath="//div [contains(text(), '200-300')]")
	public WebElement coinTrackerSize;
	
	@FindBy(xpath="//p [contains(text(), '2017')]")
	public WebElement coinTrackerYearFoundation;
	
	@FindBy(xpath="//span [contains(text(), 'San Francisco')]")
	public WebElement coinTrackerLocation;
	
	
	public void search(String text) {
		Actions action =  new Actions(driver);
		companySearch.click();
		companySearch.clear();
		companySearch.sendKeys(text);
		action.sendKeys(Keys.ENTER)
		.perform();

	}
	
	public String getText(WebElement element) {
		
		return element.getText();
	}
	
	public void categoryList(WebElement element, List<WebElement> blogPostList) {
		blogPostList.add(element);
	
	}	
}
