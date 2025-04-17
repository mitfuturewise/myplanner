package Myplanner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Dashboard extends Login {
	@Test
	public void testScroll() throws InterruptedException {

        // Increase implicit wait time if necessary
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[text()=\"Dashboard\"]")).click();
        driver.findElement(By.xpath("//*[@id='keyMetrics']/div/div[1]/div/img")).click();
        driver.findElement(By.xpath("//div[@id='keyMetrics']/div/div[3]/div/img")).click();
        Thread.sleep(20000);
     
		// Locate the element to scroll into view
        
;        WebElement element = driver.findElement(By.xpath("//*[@id='keyMetrics']/div/div[6]/div[4]"));

        // Wait for any asynchronous operations to complete (consider using explicit waits)
        Thread.sleep(1000);


        // Scroll the element into view repeatedly using JavaScript
        for (int i = 0; i < 10; i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true,{behavior: 'smooth'});", element);
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//*[@id=\"keyMetrics\"]/div/div[5]/div/img")).click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
