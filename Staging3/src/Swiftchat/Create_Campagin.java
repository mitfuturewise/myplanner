package Swiftchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;
@Listeners (TestListeners.class)
public class Create_Campagin extends Dashboard {
	private static int campaignCounter = 1;
	@Test(priority = 1)
public void campagin() throws InterruptedException {
	TestListeners.setDriver(driver);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//a[contains(.,\"Create Campaign\")]")).click();//click on create campaign
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();//click on back button
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[contains(.,\"Create Campaign\")]")).click();//click on create campaign
	 if (campaignCounter > 100) {
	        campaignCounter = 1;
	    }
	    // Build the campaign name
	    String uniqueCampaignName = "Campaign_" + campaignCounter;
	    campaignCounter++;
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(uniqueCampaignName);//Enter campaign name
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(.,\"Select Template\")]")).click();//select template dropdown
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//li[@role=\"option\"])[5]")).click();//select 5th option from template dropdown
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(.,\"Select Contacts\")]")).click();//select send to dropdown
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//li[@role=\"option\"])[1]")).click();//select 1st option from send to dropdown
	 
	 driver.findElement(By.xpath("(//button[@type=\"submit\"])")).click();//click on save button
}
	@Test(priority = 2)
	public void campaign1() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Campaign\")]")).click();//click on create campaign
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();//click on back button
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Campaign\")]")).click();//click on create campaign
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("test");//Enter campaign name
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Select Template\")]")).click();//select template dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[5]")).click();//select 5th option from template dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Select Contacts\")]")).click();//select send to dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[1]")).click();//select 1st option from send to dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();//select Body variable dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[2]")).click();//select dynamic option from body variable dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[4]")).click();//click on select option dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[1]")).click();//select 1st option(first name) from select option dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"submit\"])")).click();//click on save button
	}
	@Test(priority = 3)
	public void campaign2() throws InterruptedException {
		TestListeners.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(.,\"Create Campaign\")]")).click();//click on create campaign
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();//click on back button
		 Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])")).sendKeys("Test");//click on search bar of campaign
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-haspopup=\"menu\"])[1]")).click();//select menu on campaign screen
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@role=\"menuitem\"])")).click();//click on view campaign button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();//click on back button
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(.,\"Chats\")])[2]")).click();//click on back button
	}
}
