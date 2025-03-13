package Whatsapp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)
public class newcampaign extends Login{
	 private static int campaignCounter = 1;
	 wfnp button = new wfnp();
	 whatsapp whatsapp=new whatsapp();
@Test
public void newCampaign() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//span[contains(.,\"New Campaign\")]")).click();//new campaign
	//enter campaign name
	if (campaignCounter > 100) {
        campaignCounter = 1;
    }
    // Build the campaign name
    String uniqueCampaignName = "Campaign_" + campaignCounter;
    campaignCounter++;

    // Locate the campaign input field and send the campaign name
    driver.findElement(By.xpath("//input[@aria-required='true']")).sendKeys(uniqueCampaignName);
	driver.findElement(By.xpath("(//span[@class=\"mat-radio-inner-circle\"])[2]")).click();//select one time radio button
	driver.findElement(By.xpath("(//button[contains(text(),\"NEXT STEP\")])")).click();//click on next step
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[1]")).click();	//click dropdown button of  use case
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select use case
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
	driver.findElement(By.xpath("(//button[contains(.,\"NEXT STEP\")])")).click();//click next step(use case selection)
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(),\"NEXT STEP\")]")).click();//click next step (Audience selection)
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[contains(text(),\"Modify Template\")]")).click();//modify template
	Thread.sleep(1000);
	//for template name
	String templateName = generateUniqueTemplateName(20);
    
    // Locate the input field using the XPath and enter the unique template name
    WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='templateName']"));
    inputField.clear();
    inputField.sendKeys(templateName);
}
 public static String generateUniqueTemplateName(int length) {
	        String characters = "abdcf_54121s5d4ghjdfvdjshanb_jbdfbdsmvn6533d12f32hdfgjhsdf___hgdfnsdbf";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            sb.append(characters.charAt(index));
	        }
	        return sb.toString();
	    }
 @Test
 public void Createonfly() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[contains(.,\"New Campaign\")]")).click();//new campaign
		//enter campaign name
		if (campaignCounter > 100) {
	        campaignCounter = 1;
	    }
	    // Build the campaign name
	    String uniqueCampaignName = "Campaign_" + campaignCounter;
	    campaignCounter++;

	    // Locate the campaign input field and send the campaign name
	    driver.findElement(By.xpath("//input[@aria-required='true']")).sendKeys(uniqueCampaignName);
		driver.findElement(By.xpath("(//span[@class=\"mat-radio-inner-circle\"])[2]")).click();//select one time radio button
		driver.findElement(By.xpath("(//button[contains(text(),\"NEXT STEP\")])")).click();//click on next step
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[1]")).click();	//click dropdown button of  use case
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select use case
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
		driver.findElement(By.xpath("(//button[contains(.,\"NEXT STEP\")])")).click();//click next step(use case selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"NEXT STEP\")]")).click();//click next step (Audience selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(.,\"Create on the Fly\")]")).click();//click on create on fly
		Thread.sleep(1000);
		//for template name
		String templateName = generateUniqueTemplateName(20);
	    
	    // Locate the input field using the XPath and enter the unique template name
	    WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='templateName']"));
	    inputField.clear();
	    inputField.sendKeys(templateName);
	}
 @Test
 public void Useexistingclienttags() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[contains(.,\"New Campaign\")]")).click();//new campaign
		//enter campaign name
		if (campaignCounter > 100) {
	        campaignCounter = 1;
	    }
	    // Build the campaign name
	    String uniqueCampaignName = "Campaign_" + campaignCounter;
	    campaignCounter++;

	    // Locate the campaign input field and send the campaign name
	    driver.findElement(By.xpath("//input[@aria-required='true']")).sendKeys(uniqueCampaignName);
		driver.findElement(By.xpath("(//span[@class=\"mat-radio-inner-circle\"])[2]")).click();//select one time radio button
		driver.findElement(By.xpath("(//button[contains(text(),\"NEXT STEP\")])")).click();//click on next step
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[1]")).click();	//click dropdown button of  use case
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select use case
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
		driver.findElement(By.xpath("(//button[contains(.,\"NEXT STEP\")])")).click();//click next step(use case selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class=\"mat-radio-label\"])[2]")).click();//select use existing client tags
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"NEXT STEP\")]")).click();//click next step (Audience selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),\"Modify Template\")]")).click();//modify template
		Thread.sleep(1000);
		//for template name
		String templateName = generateUniqueTemplateName(20);
	    
	    // Locate the input field using the XPath and enter the unique template name
	    WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='templateName']"));
	    inputField.clear();
	    inputField.sendKeys(templateName);
		}
 @Test
 public void CreateTag() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[contains(.,\"New Campaign\")]")).click();//new campaign
		//enter campaign name
		if (campaignCounter > 100) {
	        campaignCounter = 1;
	    }
	    // Build the campaign name
	    String uniqueCampaignName = "Campaign_" + campaignCounter;
	    campaignCounter++;

	    // Locate the campaign input field and send the campaign name
	    driver.findElement(By.xpath("//input[@aria-required='true']")).sendKeys(uniqueCampaignName);
		driver.findElement(By.xpath("(//span[@class=\"mat-radio-inner-circle\"])[2]")).click();//select one time radio button
		driver.findElement(By.xpath("(//button[contains(text(),\"NEXT STEP\")])")).click();//click on next step
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[1]")).click();	//click dropdown button of  use case
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select use case
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
		driver.findElement(By.xpath("(//button[contains(.,\"NEXT STEP\")])")).click();//click next step(use case selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class=\"mat-radio-label\"])[3]")).click();//select create tag field
		Thread.sleep(1000);
		 String baseTag = "Tag_";
         String timestamp = String.valueOf(System.currentTimeMillis()); // Current timestamp
         String uniqueTag = baseTag + timestamp + "_" + UUID.randomUUID().toString().substring(0, 8); // Add UUID to ensure uniqueness

         System.out.println("Generated Tag: " + uniqueTag);

         // Locate the tag creation input field
         WebElement tagInputField = driver.findElement(By.xpath("(//input[@formcontrolname=\"name\"])")); // Replace with actual element locator

         // Enter the generated tag into the input field
         tagInputField.sendKeys(uniqueTag);
         Thread.sleep(1000);
        WebElement tagInputField1 =  driver.findElement(By.xpath("(//input[@formcontrolname=\"description\"])"));
        tagInputField1.sendKeys(uniqueTag);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(.,\"Create tag\")]")).click();//click on craete tag
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bar']")));
        List<String> targetNames = Arrays.asList(
        	    "Sandeep Kamble", "Mitali Kadam", "Sushil Hariakar",
        	    "Adesh Samdadiya", "Supriya Tiwari", "Ganesh Singh"
        	);

        	for (String targetName : targetNames) {
        	    // Locate the search input, clear previous text, and enter the target name
        	    WebElement searchInput = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
        	    searchInput.clear();
        	    searchInput.sendKeys(targetName);

        	    // Wait until the search result containing the target name is visible
        	    WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
        	            By.xpath("//div[normalize-space(text())='" + targetName + "']")));

        	    // Locate the checkbox container that is the immediate sibling to the name element.
        	    // Depending on the DOM structure, the checkbox may be inside this container.
        	    WebElement checkbox = driver.findElement(By.xpath(
        	        "//div[normalize-space(text())='" + targetName + "']/following::*[1]"
        	    ));

        	    // Option 1: Click directly on the container, which often triggers the checkbox toggle
        	    checkbox.click();

        	    // Optionally, wait until the checkbox is confirmed as selected before continuing
        	    wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, true));

        	    // -- Alternatively, if clicking on the container doesn't work, you can try to click the hidden checkbox input:
        	    // WebElement checkboxInput = checkboxContainer.findElement(By.xpath(".//input[@type='checkbox']"));
        	    // wait.until(ExpectedConditions.elementToBeClickable(checkboxInput));
        	    // checkboxInput.click();
        	}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"NEXT STEP\")]")).click();//click next step (Audience selection)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),\"Modify Template\")]")).click();//modify template
		Thread.sleep(1000);
		//for template name
		String templateName = generateUniqueTemplateName(20);
	    
	    // Locate the input field using the XPath and enter the unique template name
	    WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='templateName']"));
	    inputField.clear();
	    inputField.sendKeys(templateName);
		}
}

