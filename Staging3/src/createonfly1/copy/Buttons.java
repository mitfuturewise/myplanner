package createonfly1.copy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;

	@Listeners(TestListeners.class)
	public class Buttons extends Login {
		public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		public AtomicInteger responseStatus = new AtomicInteger(-1);
		newcampaign createcamp = new newcampaign();
		wfnp wfnp = new wfnp();
		bodytext bodytext = new bodytext();
	    public final String expectedUrlBase1 = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		
	    @Test(priority = 1)
		public void addwebsiteurl() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			ChromeDriver chromeDriver = (ChromeDriver) driver;
		
		}
	    @Test(priority = 2)
		public void addwebsiteurlbuttontext() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("URL");
		
		}
	    @Test(priority = 3)
		public void addwebsiteurlbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("URL");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"url\"])[1]")).sendKeys("https://my-planner.in/login");	
		
		}
	    @Test(priority = 4)
		public void phonenumber() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
		
		}
	    @Test(priority = 5)
		public void phonenumberbuttontext() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("Call");//enter text
		
		}
	    @Test(priority = 6)
		public void phonenumberbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("Call");//enter text
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"phone\"])[1]")).sendKeys("9834549528");
		
		}
	    @Test(priority = 7)
		public void quickurl() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select quickreplybutton
		
		}
	    @Test(priority = 8)
		public void quickurlbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			bodytext.bodytext();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select quickreplybutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])")).sendKeys("QuickReply");
		}
	    @Test(priority = 9)
	    public void testbuttonsclickwu() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton			
	    }
	    @Test(priority = 10)
	    public void testbuttonsclickpn() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select websiteurlbutton
	    }
	    @Test(priority =11)
	    public void testbuttonsclickqr() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
	    }
}
