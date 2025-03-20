package Whatsapp1.copy;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Whatsapp1.copy.Login;
import Whatsapp1.copy.TestListeners;
import Whatsapp1.copy.wfnp;
import Whatsapp1.copy.whatsapp;
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
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
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
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder=\"Search\"])")));;
		search.sendKeys("whatsapp");
		WebElement whatsapp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'whatsapp')]")));
		WebElement whatsapp1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'whatsapp')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
        whatsapp1.click();
//		driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[@class=\"mat-checkbox-layout\"])[2]")).click();
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
        driver.findElement(By.xpath("//button[contains(.,\"Create tag\")]")).click();//click on create tag
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        try {
       
            // Locate the search input field and enter first name
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='name']")));
            search.sendKeys("Sandeep Kamble");
            search.sendKeys(Keys.ENTER);

            // Wait until "Sandeep Kamble" is present in the search results column
            WebElement sandeep = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sandeep Kamble')]")));
            
            // Ensure the checkbox corresponding to "Sandeep Kamble" is clickable
            WebElement sandeep1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Sandeep Kamble')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
            sandeep1.click();
            Thread.sleep(2000);            // Clear search field properly and enter new name
            search.sendKeys(Keys.CONTROL + "a");
            search.sendKeys(Keys.BACK_SPACE);
            search.sendKeys("Mitali Kadam");
            search.sendKeys(Keys.ENTER);

            // Wait until "Mitali Kadam" appears in the search results
            WebElement mitali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mitali Kadam')]")));

            // Re-locate checkbox for "Mitali Kadam" to avoid stale element issues
            WebElement mitali1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Mitali Kadam')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
            mitali1.click();
//3   
            Thread.sleep(2000);
            search.sendKeys(Keys.CONTROL + "a");
            search.sendKeys(Keys.BACK_SPACE);
            search.sendKeys("Supriya Tiwari");
            search.sendKeys(Keys.ENTER);

          
            WebElement supriya = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Supriya Tiwari')]")));

           
            WebElement supriya1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Supriya Tiwari')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
            supriya1.click();
            
//            //4
//            Thread.sleep(2000);
//            search.sendKeys(Keys.CONTROL + "a");
//            search.sendKeys(Keys.BACK_SPACE);
//            search.sendKeys("Sushil Hariakar");
//            search.sendKeys(Keys.ENTER);
//
//         
//            WebElement sushil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sushil Hariakar')]")));
//
//          
//            WebElement sushil1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Sushil Hariakar')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
//            sushil1.click();
//            
//            
//            //5
//            Thread.sleep(2000);
//            search.sendKeys(Keys.CONTROL + "a");
//            search.sendKeys(Keys.BACK_SPACE);
//            search.sendKeys("Adesh Samdadiya");
//            search.sendKeys(Keys.ENTER);
//
//           
//            WebElement adesh = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Adesh Samdadiya')]")));
//
//            
//            WebElement adesh1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Adesh Samdadiya')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
//            adesh1.click();
//            
//            //6
//            Thread.sleep(2000);
//            search.sendKeys(Keys.CONTROL + "a");
//            search.sendKeys(Keys.BACK_SPACE);
//            search.sendKeys("Ganesh Singh");
//            search.sendKeys(Keys.ENTER);
//
//           
//            WebElement ganesh = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Ganesh Singh')]")));
//
//           
//            WebElement ganesh1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ganesh Singh')]/ancestor::tr//label[@class='mat-checkbox-layout']")));
//            ganesh1.click();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    // Safe Click method to handle stale element exceptions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type=\"undefined\"])"))).click();//click next step (Audience selection)
		Thread.sleep(1000);
		  WebElement modifyTemplateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Modify Template')]")));

          // ✅ Scroll into view before clicking
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modifyTemplateButton);
          Thread.sleep(500);  // Allow time for scrolling

          // ✅ Click using JavaScript (if normal click fails)
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", modifyTemplateButton);
		//for template name
		String templateName = generateUniqueTemplateName(20);
	    
	    // Locate the input field using the XPath and enter the unique template name
	    WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='templateName']"));
	    inputField.clear();
	    inputField.sendKeys(templateName);
		}
}

