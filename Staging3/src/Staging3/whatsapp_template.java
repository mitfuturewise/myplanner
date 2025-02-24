package Staging3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class whatsapp_template extends Login{
WhatsApp template = new WhatsApp();
publish_next footer = new publish_next();
@Test
public void Template() throws InterruptedException {
	TestListeners.setDriver(driver);
	template.whatsapp();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select text from header dropdown
	footer.footer();
	boolean isValid = false;
    try {
        // Attempt to click "NEXT STEP" and wait for a specific element
        driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"textZindex\"]")));
        String ele = element.getTagName();
        System.out.println(ele);
        System.out.println("not valid");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(.,\"Cancel\")]")).click();
        // If this block runs, the scenario is "not valid"
    } catch (Exception e) {
        // Exception means we are in the "valid" case as per your logic
        System.out.println("valid");
        isValid = true;
    }
    
    // If the try block succeeded (i.e. not valid), click Cancel
//    if (!isValid) {
//        driver.findElement(By.xpath("//p[contains(.,\"Cancel\")]")).click();
//    }
//	driver.findElement(By.xpath("(//input[@aria-invalid='false'])[4]")).sendKeys("Hello");
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
//	driver.findElement(By.xpath(""));
}
}
