package Myplanner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class Gamification {
	public static WebDriver driver;
	private WebDriverWait wait;
	@Test
	public void gamification() {
	TestListeners.setDriver(driver);
    driver = new ChromeDriver();

    // Open the login page and perform login
    driver.get("https://my-planner.in/woselect");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("sonesh.dedhia@manekfinancial.com");
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("123#Manek@!");
    driver.findElement(By.xpath("//button[contains(@class, 'mainloginBtn')]")).click();
	}
}