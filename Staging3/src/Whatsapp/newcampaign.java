package Whatsapp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@aria-required=\"true\"])")).click();//click on calender to select date
//	LocalDate targetDate = LocalDate.now();
//
//	
//	
//	// Format the date to match the aria-label pattern ("MMMM d, yyyy")
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
//	String targetDateLabel = targetDate.format(formatter);
//
//	// Build dynamic XPath using the aria-label attribute
//	String dynamicXPath = "//button[@type='button' and @aria-label='" + targetDateLabel + "']";
//
//	// Locate the button and click it
//	WebElement dateButton = driver.findElement(By.xpath(dynamicXPath));
//	dateButton.click();
	
//	driver.findElement(By.xpath("(//mat-select[@aria-required=\"true\"])[2]")).click();//select dropdown to select time
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[13]")).click();
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
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//    driver.findElement(By.xpath("(//span[contains(.,\" Publish \")])[2]")).click();
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
	 
}
//for footer (//input[@aria-invalid="false"])[6]
//next step(Template selection screen)(//span[contains(.," NEXT STEP ")])[2]
//publish
//header dropdown to selectcion-text-(//mat-select[@aria-disabled='false'])[2]
//header ->select text from dropdown of header (//span[@class="mat-option-text"])[2]
//header selectcion-text-send text-(//input[@aria-invalid='false'])[4]
//add variable ->header (//p[contains(.,'Add Variable')])[1]
//select header datapoin->(//mat-select[@formcontrolname="headerPlaceholdervariable"])
//select header 1st option of datapoint-(//span[@class="mat-option-text"])[1]
//click header fallbackvalue-(//input[@formcontrolname="headerFallbackvalue"])
//click body-(//p[contains(.,'Add Variable')])[2]
//click body add variable datapoint dropdown-(//mat-select[@formcontrolname="datapoint"])
//select datapoint in body section-(//span[@class="mat-option-text"])[1]
//select fallbackvalue in body section-(//input[@formcontrolname="fallbackValue"])
//click footer-(//input[@aria-required="false"])[2]
//click dropdown of buttons-(//mat-select[@formcontrolname="selectedButtonType"])
//select option of button-(//span[@class="mat-option-text"])[1]
//add text to buttontext-(//input[@formcontrolname="buttonText"])[1]
//add buttontext url-(//input[@formcontrolname="url"])[1]
//phonenumber-(//input[@formcontrolname="buttonText"])[1]
//phoneuber text-(//input[@formcontrolname="phone"])[1]
//quick reply-(//input[@formcontrolname="buttonText"])[3]
//(//div[@class="chat-container"])
// driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//driver.findElement(By.xpath("(//span[contains(.,\" Publish \")])[2]")).click();
