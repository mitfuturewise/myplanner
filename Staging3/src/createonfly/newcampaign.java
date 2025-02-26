package createonfly;

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
	    Thread.sleep(1000);
	    
	}
	 
}
