package Swiftchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;
@Listeners (TestListeners.class)
public class Create_contact extends Dashboard{
	@Test
public void Contact() throws InterruptedException {
	TestListeners.setDriver(driver);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//a[contains(.,\"Add Contact\")]")).click();//click on add contact on dashboard
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Nikhil");//search contact
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[contains(.,\"Add Contact\")]")).click();//click on add contact
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(.,\"Save\")]")).click();//click on save while adding contact to check required fields
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Mitali");//enter first name
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("Kadam");//enter last name
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])")).sendKeys("9834549528");//enter phone number
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[contains(.,\"Save\")]")).click();//click on save
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("(//span[contains(.,\"Dashboard\")])[1]")).click();//click on dashboard
}
}
