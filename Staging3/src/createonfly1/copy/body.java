package createonfly1.copy;
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
@Listeners(TestListeners.class)
public class body extends Login {
	newcampaign createcamp = new newcampaign();
	wfnp wfnp = new wfnp();
	bodytext bodytext = new bodytext();
    public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
	
    @Test(priority = 1)
	public void addvariable() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		bodytext.bodytext();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])")).click();//click on add variable in body section
		Thread.sleep(1000);
	}
    @Test(priority = 2)
    public void selectdatapoint() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		bodytext.bodytext();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])")).click();//click on add variable in body section
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"datapoint\"])")).click();//select dropdown of datapoint
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select first option from datapoint dropdown
	}
    @Test(priority = 3)
    public void selectdatapointandfallbackvalue() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		bodytext.bodytext();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement addVariable = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[contains(.,'Add Variable')])")));

	    // Scroll into view and click safely
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addVariable);
	    Thread.sleep(300);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addVariable);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"datapoint\"])")).click();//select dropdown of datapoint
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select first option from datapoint dropdown
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@formcontrolname=\"fallbackValue\"])")).sendKeys("user");
	}
}
