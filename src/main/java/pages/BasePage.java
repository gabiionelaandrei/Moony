package pages;

import org.openqa.selenium.WebDriver;
import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	public MenuPage menu =  new MenuPage(driver);
	public CompaniesPage coinCompany = new CompaniesPage(driver);
	public MyAccount account = new MyAccount(driver);
	public JobPages job = new JobPages(driver);
}