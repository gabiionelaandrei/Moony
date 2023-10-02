package tests;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

public class CoinTrackerCompany {
	
	@Listeners(TestNgListener.class)
	public class LoginTest extends BaseTest {
	
		@Test(priority = 1)
		public void searchCompany() throws InterruptedException {

			app.click(app.menu.companiesMenu);
			app.coinCompany.search("Coin");
			Thread.sleep(3000);
			app.coinCompany.coinTracker.click();		
			Thread.sleep(3000);
			
			//follow up
			app.coinCompany.followButton.click();
			app.coinCompany.getText(app.coinCompany.loginPopUp);
			assertTrue(app.coinCompany.getText(app.coinCompany.loginPopUp).equals("Log in"));
			app.coinCompany.closePopUp.click();
			
			//website
			app.coinCompany.visitWebsite.click();
			System.out.println("Current window (moony.ro):" + driver.getWindowHandle());
			System.out.println("All windows (moony.ro and https://www.cointracker.io/) :" + driver.getWindowHandles());
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			assertTrue(driver.getCurrentUrl().equals("https://www.cointracker.io/"));
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
			System.out.println("Current window after tab close:" + driver.getWindowHandle());
			
			//send message
			app.coinCompany.sendMessage.click();
			app.coinCompany.getText(app.coinCompany.loginPopUp);
			assertTrue(app.coinCompany.getText(app.coinCompany.loginPopUp).equals("Log in"));
			app.coinCompany.closePopUp.click();
		
			
	        List<WebElement> coinCategoryList = new ArrayList<WebElement>();
			
	        app.coinCompany.categoryList(app.coinCompany.b2bCategory, coinCategoryList);
	        app.coinCompany.categoryList(app.coinCompany.webCategory, coinCategoryList);

			for (WebElement category : coinCategoryList) {		
				assertTrue(app.coinCompany.getText(category).equals("B2B SaaS") || app.coinCompany.getText(category).equals("Web Development"));
	        }
			
			assertTrue(app.coinCompany.getText(app.coinCompany.coinTrackerSize).equals("200-300"));
			assertTrue(app.coinCompany.getText(app.coinCompany.coinTrackerYearFoundation).equals("2017"));
			assertTrue(app.coinCompany.getText(app.coinCompany.coinTrackerLocation).equals("San Francisco"));
		}
	}
}
