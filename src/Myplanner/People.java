package Myplanner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class People extends Login {
	@Test(priority = 1)
	public void client() {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Search for a client or family member\"]")).sendKeys("Sandeep Abhimanyu Kamble");// search bar
        driver.findElement(By.xpath("//*[@id=\"mat-option-1\"]/span/div/div[2]")).click(); //first name click
	}
	@Test(priority = 2)
	public void testPeopleProfileEditing()  throws InterruptedException {
//        JavascriptExecutor j=(JavascriptExecutor) driver;
//        Thread.sleep(2000);
//        j.executeScript("window.scrollBy(0,8000)");
//        Thread.sleep(2000);
		TestListeners.setDriver(driver);
        driver.findElement(By.xpath("//*[@id=\"mat-tab-link-6\"]")).click();//profile->key info
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@class=\"f-12 text-primary primary-border c-p editCLass ng-star-inserted\"])[1]")).click(); //edit button
        driver.findElement(By.xpath("//*[@id=\"mob-res-575\"]/div[2]/app-progess-button-white/div/button")).click();//save and next(basic details)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class=\"primary\"]")).click();// save and next (more info)
        driver.findElement(By.xpath("//*[@id=\"mob-res-575\"]/app-progess-button-white/div/button")).click();//save and next(address)
        driver.findElement(By.xpath("(//div[@role=\"tab\"])[5]")).click();//demat
        driver.findElement(By.xpath("(//div[@role=\"tab\"])[6]")).click();//upload
        driver.findElement(By.xpath("(//div[@role=\"tab\"])[1]")).click();//basic details
//        driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[2]")).click();//resident status
//        driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[2]")).click();//select option resident status
        driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();//save and close(basic details)
        driver.findElement(By.xpath("//*[@id=\"ui-overview-profile\"]/div/div[1]/ul/li[2]")).click();//risk profile
        driver.findElement(By.xpath("//*[@id=\"ui-overview-profile\"]/div/div[1]/ul/li[3]")).click();//manage kyc

    }
}
