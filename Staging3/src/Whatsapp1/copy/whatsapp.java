package Whatsapp1.copy;

import java.time.Duration;
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
public class whatsapp extends Login{
	 private static int campaignCounter = 1;
	 wfnp button = new wfnp();
@Test
public void whatsapp() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("(//span[contains(.,\"WhatsApp\")])[3]")).click();//whatsapp click
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,\"CAMPAIGNS\")]")).click();//click campaign
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
