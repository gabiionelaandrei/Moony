package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class JobPages extends SeleniumWrappers{

	public JobPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "jobs_filter_search") 
	public WebElement searchMenu;
	
	@FindBy(xpath = "//button [contains(text(), 'Search')]") 
	public WebElement searchButton;
	
	@FindBy(xpath = "//a [contains(text(), 'Test Engineer at KeyTest')]") 
	public WebElement keyTest;

	@FindBy(xpath = "//div[@class='jobs-apply-sidebar block-archive-sidebar ']/a [contains(text(), 'Apply now')]") 
	public WebElement applyButton;
	
	@FindBy(xpath = "//a [contains(text(), 'Overview')]") 
	public WebElement overview;

	@FindBy(xpath = "//div[@class='apply-popup']") 
	public WebElement popUp;
	
	@FindBy(xpath = "//i[@class='fal fa-phone-alt']") 
	public WebElement phoneButton;
	
	
	
	
	public void search(WebElement element,String text) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
		jse.executeScript("arguments[0].value= '"+ text + "';",  element);
		jse.executeScript("arguments[0].click()", searchButton);
	}
	
	public boolean elementIsDisplayed(WebElement element, String string) {		
		return element.getText().contains(string);
	}
	

}
