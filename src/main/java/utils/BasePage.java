package utils;

import org.openqa.selenium.WebDriver;

import pages.CompaniesPage;
import pages.JobPages;
import pages.MenuPage;
import pages.MyAccount;
import tests.ApplyToJob;
import tests.CoinTrackerCompany;


public class BasePage  extends SeleniumWrappers{
	

	public BasePage(WebDriver driver) {
		super(driver);
	
	}
	public MenuPage menu =  new MenuPage(driver);
	public CompaniesPage coinCompany = new CompaniesPage(driver);
	public MyAccount account = new MyAccount(driver);
	public JobPages job = new JobPages(driver);
	
}