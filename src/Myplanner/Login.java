package Myplanner;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;
@Listeners(TestListeners.class)
public class Login {
	 public static WebDriver driver;
	    private WebDriverWait wait;


	    @BeforeClass
	    public void setUp() throws InterruptedException {
	        // Initialize the driver and assign it to the class field
	    	TestListeners.setDriver(driver);
	        driver = new ChromeDriver();

	        // Open the login page and perform login
	        driver.get("https://staging3.ifanow.in/login");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	        driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("mitalikadam29052001@gmail.com");
//	        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Ifanow@123");
	        driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("sonesh.dedhia@manekfinancial.com");
	        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("123#Manek@!");
	        driver.findElement(By.xpath("//button[contains(@class, 'mainloginBtn')]")).click();
	    }
//	    @Test
//	    public void getSs() throws IOException, InterruptedException {
//	    TakesScreenshot t=(TakesScreenshot) driver;
//	    File src = t.getScreenshotAs(OutputType.FILE);
//	    File dest=new File("./Screenshots/ss.png");
//	    Files.copy(src, dest);
//	    }
}