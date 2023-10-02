package utils;

import org.openqa.selenium.WebDriver;

import pages.CompaniesPage;
import pages.MenuPage;
import tests.CoinTrackerCompany;


public class BasePage  extends SeleniumWrappers{
	

	public BasePage(WebDriver driver) {
		super(driver);
	
	}
	public MenuPage menu =  new MenuPage(driver);
	public CompaniesPage coinCompany = new CompaniesPage(driver);
	
}