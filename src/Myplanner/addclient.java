package Myplanner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (TestListeners.class)
@Test(priority=1)
public class addclient extends Login{
	public void addclient() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//span[contains(.,\"People\")])[3]")).click();//click to people option
		WebElement search = driver.findElement(By.xpath("//input[@role=\"combobox\"]"));//search client and familymember
		Thread.sleep(1000);
		search.sendKeys("sonesh");
		Thread.sleep(1000);
		search.clear();
		Thread.sleep(1000);
		search.sendKeys("Jinita");
		Thread.sleep(1000);
		search.clear();
		Thread.sleep(1000);
		WebElement search1 = driver.findElement(By.xpath("(//input[@data-placeholder=\"Type to search client\"])[1]"));//search on searchbar where we can search for only client.
		Thread.sleep(1000);
		search1.sendKeys("sonesh");
		Thread.sleep(1000);
		search1.clear();
	}
	@Test(priority=2)
	public  void addclient1() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement people = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\"People\")])[3]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", people);
        WebElement add = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,\" ADD NEW \")]")));
		driver.findElement(By.xpath("//span[contains(.,\" ADD NEW \")]")).click();
		String today = java.time.LocalDate.now().toString().replaceAll("-", "");
        String testName = "Test" + today;
        driver.findElement(By.xpath("//input[@placeholder=\"Enter name\"]")).sendKeys(testName);
        driver.findElement(By.xpath("//input[@data-placeholder=\"Enter email\"]")).sendKeys(testName+"@mailinator.com");
        driver.findElement(By.xpath("//input[@formcontrolname=\"number\"]")).sendKeys("9875641235");
        String uniquePAN = generateFakePAN();
        WebElement panField = driver.findElement(By.xpath("//input[@placeholder=\"Enter pan\"]"));
        panField.sendKeys(uniquePAN);
        Thread.sleep(1000);
        WebElement dobInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='dobAsPerRecord']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dobInput);
        Thread.sleep(300);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dobInput);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@aria-label=\"Choose month and year\"])")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//span[@class=\"mat-button-focus-overlay\"])[9]")).click();
         driver.findElement(By.xpath("(//button[@aria-label=\"2016\"])")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//button[@aria-label=\"February 2016\"])")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//button[@aria-label=\"February 2, 2016\"])")).click();
         Thread.sleep(1000);
         WebElement gender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class=\"mat-radio-label-content\"])[2]")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
         Thread.sleep(300);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);
         Thread.sleep(1000);
         WebElement owner = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\"Select owner\")])[1]")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", owner);
         Thread.sleep(300);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", owner);
         Thread.sleep(1000);
         WebElement selectowner = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\" Sonesh Navinchandra Dedhia \")])")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectowner);
         Thread.sleep(300);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectowner);
         Thread.sleep(1000);
         WebElement role = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\"Select roles\")])[1]")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", role);
         Thread.sleep(300);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", role);
         Thread.sleep(1000);
         WebElement selectrole = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(.,\" Advanced Financial Plan\")])[1]")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectrole);
         Thread.sleep(300);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectrole);
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//button[@type=\"undefined\"])[1]")).click();
         Thread.sleep(1000);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"cdk-overlay-container\"]")));
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"cdk-overlay-container\"]")));
        WebElement next = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type=\"undefined\"])[1]")));
        next.click();
        driver.findElement(By.xpath("//input[@formcontrolname=\"addressLine1\"]")).sendKeys("002/A");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"addressLine2\"]")).sendKeys("asdf");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"pinCode\"]")).sendKeys("401305");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).sendKeys("Mumbai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"state\"]")).sendKeys("Mahrashtra");
        driver.findElement(By.xpath("//input[@formcontrolname=\"country\"]")).sendKeys("India");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type=\"undefined\"])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"ifscCode\"]")).sendKeys("SBIN0000455");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname=\"accNumber\"]")).sendKeys("123456789123456789");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[contains(.,\"Select account type\")])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
        Thread.sleep(1000);
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
//        	    By.xpath("//input[@placeholder='Type to search client']")));
//        	searchBox.clear();
//        	searchBox.sendKeys(testName);
//        	Thread.sleep(1000); // small wait for list to load

        	// Step 2: Keep deleting while test entries exist
        	while (true) {
        	    WebElement searchBox1 = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("//input[@placeholder='Type to search client']")));

        	    searchBox1.clear(); // Clear old value
        	    searchBox1.sendKeys(testName);

        	    // 🔁 Wait until the client row with testName is visible
        	    try {
        	        wait.until(ExpectedConditions.presenceOfElementLocated(
        	            By.xpath("//div[contains(text(),'" + testName + "')]/ancestor::tr")));

        	        List<WebElement> rows = driver.findElements(
        	            By.xpath("//div[contains(text(),'" + testName + "')]/ancestor::tr"));

        	        if (!rows.isEmpty()) {
        	            // ✅ Success — result loaded
        	            break;
        	        }
        	    } catch (TimeoutException e) {
        	        // Retry sending if not found in time
        	        System.out.println("Result not found, retrying...");
        	    }
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
//        	WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
//        	        By.xpath("(//button[@role=\"menuitem\"])[5]")));
//        	deleteBtn.click();
//        Select s =new Select(year);
//        s.selectByValue("2016");
//        WebElement yearMonthButton = wait.until(ExpectedConditions.presenceOfElementLocated(
//        	    By.xpath("(//span[@class='mat-button-wrapper'])[8]")
//        	));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearMonthButton);
//        	Thread.sleep(300);
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearMonthButton);
//
//        	// 4. Select Year (1998)
//        	WebElement year = wait.until(ExpectedConditions.presenceOfElementLocated(
//        	    By.xpath("(//div[contains(.,' 1998 ')])[6]")
//        	));
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", year);
//        	Thread.sleep(300);
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", year);
//
//        	// 5. Select Month (FEB)
//        	WebElement month = wait.until(ExpectedConditions.presenceOfElementLocated(
//        	    By.xpath("(//div[contains(.,' FEB ')])[6]")
//        	));
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", month);
//        	Thread.sleep(300);
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", month);
//
//        	// 6. Select Day (9)
//        	WebElement day = wait.until(ExpectedConditions.presenceOfElementLocated(
//        	    By.xpath("(//div[contains(.,' 9 ')])[6]")
//        	));
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", day);
//        	Thread.sleep(300);
//        	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", day);
        


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
//	public static String getRandomDOB() {
//	    LocalDate start = LocalDate.of(1980, 1, 1);
//	    LocalDate end = LocalDate.of(2000, 12, 31);
//	    long days = ChronoUnit.DAYS.between(start, end);
//	    LocalDate randomDate = start.plusDays(new Random().nextInt((int) days));
//	    return randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//	}
	

}
