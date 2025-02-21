package Staging3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class WhatsApp extends Login{
@Test
public void whatsapp() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("(//span[contains(.,\"WhatsApp\")])[3]")).click();//whatsapp click
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,\"CAMPAIGNS\")]")).click();//click campaign
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(.,\"New Campaign\")]")).click();//new campaign
	String uniqueCampaignName = "Campaign_" + UUID.randomUUID().toString();//
	driver.findElement(By.xpath("//input[@aria-required=\"true\"]")).sendKeys(uniqueCampaignName);//send text to new campaign textfield
	driver.findElement(By.xpath("(//span[@class=\"mat-radio-inner-circle\"])[2]")).click();//select one time radio button
	driver.findElement(By.xpath("(//button[contains(text(),\"NEXT STEP\")])")).click();//click on next step
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[1]")).click();	//click dropdown button of  use case
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select use case
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
	LocalDate targetDate = LocalDate.now();

	// Format the date to match the aria-label pattern ("MMMM d, yyyy")
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
	String targetDateLabel = targetDate.format(formatter);

	// Build dynamic XPath using the aria-label attribute
	String dynamicXPath = "//button[@type='button' and @aria-label='" + targetDateLabel + "']";

	// Locate the button and click it
	WebElement dateButton = driver.findElement(By.xpath(dynamicXPath));
	dateButton.click();
	
	driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[2]")).click();//select dropdown to select time
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[13]")).click();
	driver.findElement(By.xpath("(//button[contains(.,\"NEXT STEP\")])")).click();//click next step(use case selection)
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(),\"NEXT STEP\")]")).click();//click next step (Audience selection)
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[contains(text(),\"Modify Template\")]")).click();//modify template
}

@Test
public void enterUniqueTemplateName() {
    // Wait until the template name text field is visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement templateNameField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-required='true'])[1]"))
    );

    // Generate a unique template name (max 25 characters)
    String uniqueTemplateName = generateUniqueTemplateName();

    // Clear the field and enter the unique template name
    templateNameField.clear();
    templateNameField.sendKeys(uniqueTemplateName);

    // Optionally, print the entered value for verification
    String enteredValue = templateNameField.getAttribute("value");
    System.out.println("Entered unique template name: " + enteredValue);
}

// Helper method to generate a unique template name up to 25 characters
public static String generateUniqueTemplateName() {
    // Using UUID to generate a unique string and then remove hyphens
    String uniqueName = UUID.randomUUID().toString().replaceAll("-", "");
    if (uniqueName.length() > 25) {
        uniqueName = uniqueName.substring(0, 25);
    }
    return uniqueName;
}
}
