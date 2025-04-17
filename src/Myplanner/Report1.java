package Myplanner;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class Report1 extends Login{
	People client = new People();
	@Test
	public void match() throws InterruptedException {
		client.client();
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("(//a[@class=\"mat-tab-link mat-focus-indicator ng-star-inserted\"])[3]")).click();//report
		 Thread.sleep(1000);
		String targetReportName = "t";

		// Find all checkboxes in rows where the report name matches the target value
		List<WebElement> matchingCheckboxes = driver.findElements(By.xpath(
		    "//tr[td//div[normalize-space(text())='" + targetReportName + "']]//mat-checkbox[@name='selectedData']"
		));

		// Loop through each matching checkbox and click it
		for (WebElement checkbox : matchingCheckboxes) {
		    checkbox.click();
		}
	}
}
