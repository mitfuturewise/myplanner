package Myplanner;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class addtm extends Login{
	@Test(priority=1)
	public  void addtm() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//span[contains(.,\"People\")])[3]")).click();
		driver.findElement(By.linkText("TEAM MEMBERS")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(.,\" ADD NEW \")]")).click();
		String today = java.time.LocalDate.now().toString().replaceAll("-", "");
        String testName = "Test" + today;
        driver.findElement(By.xpath("//input[@formcontrolname=\"fullName\"]")).sendKeys(testName);
        String uniquePAN = generateFakePAN();
        driver.findElement(By.xpath("//input[@placeholder=\"Enter email Id\"]")).sendKeys(uniquePAN+"@mailinator.com");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//         WebElement selectowner = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\" Sonesh Navinchandra Dedhia \")])")));
//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectowner);
//         Thread.sleep(300);
//         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectowner);
        driver.findElement(By.xpath("//input[@formcontrolname=\"mobileNo\"]")).sendKeys("9856471235");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//mat-select[@formcontrolname=\"roleId\"]")).click();//select role
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select first option from role dropdown
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[3]")).click();//select tagline
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select 1st option from tag line dropdown
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type=\"undefined\"])"));
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
        	    By.xpath("//input[@placeholder='Type to search client']")));
        	searchBox.clear();
        	searchBox.sendKeys(testName);
        	Thread.sleep(1000); // small wait for list to load

        	// Step 2: Keep deleting while test entries exist
        	while (true) {
        		searchBox = wait.until(ExpectedConditions.elementToBeClickable(
        		        By.xpath("//input[@placeholder='Type to search client']")));
        		    searchBox.clear();
        		    searchBox.sendKeys(testName);
        		    Thread.sleep(1000); // Wait for results to load

        		    List<WebElement> rows = driver.findElements(By.xpath("//div[contains(text(),'" + testName + "')]/ancestor::tr"));

        	    if (rows.isEmpty()) {
        	        System.out.println("No more test entries found.");
        	        break;
        	    }

        	    // Find the first matching row’s menu button and click
        	    WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("(//div[contains(text(),'" + testName + "')]/ancestor::tr//td[@aria-haspopup='menu'])[1]")));
        	    menuBtn.click();
        	    WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
            	        By.xpath("(//button[@role=\"menuitem\"])[5]")));
            	deleteBtn.click();
            	WebElement deleteBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
            	        By.xpath("(//button[@type=\"undefined\"])")));
            	deleteBtn1.click();
            	
        	}
	}
	public static String generateFakePAN() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        StringBuilder pan = new StringBuilder();

        // First 5 letters
        for (int i = 0; i < 5; i++) {
            pan.append(letters.charAt(random.nextInt(letters.length())));
        }

        // Next 4 digits
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10));
        }

        // Last letter
        pan.append(letters.charAt(random.nextInt(letters.length())));

        return pan.toString();
    }

}

