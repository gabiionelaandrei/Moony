package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

public class ApplyToJob {

	@Listeners(TestNgListener.class)
	public class LoginTest extends BaseTest {

		@Test(priority = 1)
		public void applyToJob() throws InterruptedException {

			app.click(app.menu.loginMenu);
			app.account.loginInApp("johnnybravo@key-training.ro", "johnnybravo@123");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h2 [contains(text(), 'Welcome back! JohnnyBravo')]")));

			app.account.jobsPage.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h2 [contains(text(), 'Find Your Dream Jobs')]")));

			app.job.search(app.job.searchMenu, "Test Engineer");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='filter-warpper']/div/span [contains(text(), 'jobs for \"Test Engineer\"')]")));

			app.job.keyTest.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1 [contains(text(), 'Test Engineer at KeyTest')]")));

			assertTrue(app.job.elementIsDisplayed(app.job.applyButton, "Apply now"));
			assertTrue(app.job.elementIsDisplayed(app.job.overview, "Overview"));

			app.job.applyButton.click();
			assertTrue(app.job.popUp.isDisplayed());

			app.job.phoneButton.click();
			driver.switchTo().alert().dismiss();

		}
	}

}
