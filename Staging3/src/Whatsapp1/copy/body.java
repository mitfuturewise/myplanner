package Whatsapp1.copy;
import java.awt.AWTException;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;
import Whatsapp.newcampaign;
@Listeners(TestListeners.class)
public class body extends Login {
	newcampaign createcamp = new newcampaign();
	wfnp wfnp = new wfnp();
    public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
	
    @Test(priority = 1)
	public void waddvariable() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])")).click();//click on add variable in body section
	}
    @Test(priority = 2)
    public void wselectdatapoint() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])")).click();//click on add variable in body section
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"datapoint\"])[3]")).click();//select dropdown of datapoint
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select first option from datapoint dropdown
	}
    @Test(priority = 3)
    public void wselectdatapointandfallbackvalue() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])")).click();//click on add variable in body section
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"datapoint\"])[3]")).click();//select dropdown of datapoint
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select first option from datapoint dropdown
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@formcontrolname=\"fallbackValue\"])[3]")).sendKeys("user");
//		Thread.sleep(1000);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("your_xpath_here")));
//
//         // ✅ Scroll into view before typing
//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
//         Thread.sleep(500); // Allow time for scrolling
//
//         // ✅ Remove "readonly" if needed
//         ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly');", inputField);
//
//         // ✅ Clear the field before typing
//         inputField.clear();
//
//         // ✅ Type into the input field
//         inputField.sendKeys("Your Text Here");
}
}
