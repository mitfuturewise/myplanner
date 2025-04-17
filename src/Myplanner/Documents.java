package Myplanner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class Documents extends Login {
	People client = new People();

	@Test
	public void Documents() throws AWTException, InterruptedException {
		 client.client();
		 TestListeners.setDriver(driver);
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//a[@class=\"mat-tab-link mat-focus-indicator ng-star-inserted\"])[2]")).click();//documents
		driver.findElement(By.xpath("//*[@id=\"ui-documents-overview\"]/div/div[2]/div/div[1]/div[2]/button")).click();//Add button
		driver.findElement(By.xpath("(//button[@role='menuitem'])[1]")).click();//upload file
		Robot robot = new Robot();
		StringSelection selection = new StringSelection("C:\\Users\\HP\\Downloads\\Sonesh Navinchandra Dedhia's Portfolio Summary as on Fri Feb 14 2025 16_10_30 GMT+0530 (India Standard Time).pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    
	    // Paste the file path: CTRL+V
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    
	    // Small delay to ensure the paste is completed.
	   Thread.sleep(1000);
	    
	    // Press Enter to confirm the file upload.
	    robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadSuccess")));
	    String filename = "Sonesh Navinchandra Dedhia's Portfolio Summary as on Fri Feb 14 2025 16_10_30 GMT+0530 (India Standard Time).pdf";
		WebElement search = driver.findElement(By.xpath("//input[@aria-invalid=\"false\"]"));//search bar(document)
	    Thread.sleep(1000);
		search.sendKeys(filename);
		//		driver.findElement(By.xpath("")).click();//
//		driver.findElement(By.xpath("")).click();//
//		driver.findElement(By.xpath("")).click();//
	}

}
