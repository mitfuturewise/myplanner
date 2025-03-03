package Swiftchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;
@Listeners (TestListeners.class)
public class Create_contact extends Dashboard{
	@Test
public void Contact() {
	TestListeners.setDriver(driver);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//a[contains(.,\"Add Contact\")]")).click();//click on add contact on dashboard
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Mitali");//search contact
	 driver.findElement(By.xpath("//span[contains(.,\"Save\")]")).click();//click on save while adding contact to check required fields
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Mitali");//enter first name
	 driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("Kadam");//enter last name
	 driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])")).sendKeys("9834549528");//enter phone number
	 driver.findElement(By.xpath("//span[contains(.,\"Save\")]")).click();//click on save
	 driver.findElement(By.xpath("(//span[contains(.,\"Dashboard\")])[1]")).click();//click on dashboard
}
}
