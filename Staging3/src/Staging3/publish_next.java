package Staging3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class publish_next extends Login{
	
	@Test
	public void next() throws InterruptedException {
		driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
	}
	@Test
	public void publish() {
		driver.findElement(By.xpath("(//span[contains(.,\" Publish \")])[2]")).click();
	}
public void footer() {
	driver.findElement(By.xpath("(//input[@aria-required=\"false\"])[3]")).sendKeys("Thank you for choosing us.");//footer
    driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//select button dropdown
    driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//choose first option from dropdown
    driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("Redirect");//add text to buttontext-
    driver.findElement(By.xpath("(//input[@formcontrolname=\"url\"])[1]")).sendKeys("https://google.com");//add buttontext url 
}
}
