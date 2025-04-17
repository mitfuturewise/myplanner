package Myplanner;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class Report extends Login {
	People client = new People();

	@Test
	public void Report() throws AWTException, InterruptedException {
		 client.client();
		 TestListeners.setDriver(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.xpath("(//a[@class=\"mat-tab-link mat-focus-indicator ng-star-inserted\"])[3]")).click();//report
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//span[@class=\"mat-button-wrapper\"])[4]")).click();//create report
		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled=\"false\"])[1]")).click();//expand portfolio summary
		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();//portfolio summary
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled=\"false\"])[2]")).click();//expand portfolio summary
		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[3]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled=\"false\"])[3]")).click();//expand portfolio summary
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled=\"false\"])[4]")).click();//expand portfolio summary
		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[10]")).click();
		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled=\"false\"])[5]")).click();//expand portfolio summary
		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[13]")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
// Wait until the element (e.g., popup) is no longer visible on the page.
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"mat-button-wrapper\"])[3]")));
		 element.click();
		 driver.findElement(By.xpath("//button[text()='SAVE']")).click();
		 Thread.sleep(2000);
		 String targetReportName = "t";

		// Find all checkboxes in rows where the report name matches the target value
		List<WebElement> matchingCheckboxes = driver.findElements(By.xpath(
		    "//tr[td//div[normalize-space(text())='" + targetReportName + "']]//mat-checkbox[@name='selectedData']"
		));

		// Loop through each matching checkbox and click it
		for (WebElement checkbox : matchingCheckboxes) {
		    checkbox.click();
		}
;//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[7]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[8]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[9]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[10]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[11]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[12]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		 driver.findElement(By.xpath("(//mat-expansion-panel-header[@aria-disabled="false"])[13]")).click();//expand portfolio summary
//		 driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
	}
}
