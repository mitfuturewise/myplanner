package Swiftchat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;

@Listeners (TestListeners.class)
public class Create_Template extends Dashboard {
	bodytext bodytext = new bodytext();
	@Test
	public void template() throws InterruptedException {
		TestListeners.setDriver(driver);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Template\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Template\")]")).click();
		 Thread.sleep(1000);
		 String templateName = generateUniqueTemplateName(20);
		    
		    // Locate the input field using the XPath and enter the unique template name
		    WebElement inputField = driver.findElement(By.xpath("(//input[@type=\"text\"])[1]"));
		    inputField.clear();
		    inputField.sendKeys(templateName);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();//select category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[2]")).click();//select 2nd option (marketing) from category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();//select language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[15]")).click();//select 25th option(gujrati) from language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Hello {{1}}");//enter text to header
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@placeholder=\"Enter content for {{1}}\"])")).sendKeys("user");//enter variable
		 Thread.sleep(1000);
		 bodytext.bodytext();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("Ifanow");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("Client");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[4]/div/div/div/textarea")).sendKeys("Sincerely, Ifanow");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Call phone number (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Visit website (2)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Copy offer code (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Custom button (6)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[6]")).sendKeys("Call");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[7]")).sendKeys("India");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[8]")).sendKeys("+919834549528");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[9]")).sendKeys("Redirect");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type=\"url\"]")).sendKeys("https://my-planner.in/login");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[10]")).sendKeys("Coupon");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[11]")).sendKeys("dhgfhg");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[12]")).sendKeys("Share");
		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("(//span[contains(.,\"Create Template\")])[2]")).click();
		 
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
	public void image() throws InterruptedException, AWTException {
		TestListeners.setDriver(driver);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Template\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Back\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[contains(.,\"Create Template\")]")).click();
		 Thread.sleep(1000);
		 String templateName = generateUniqueTemplateName(20);
		    
		    // Locate the input field using the XPath and enter the unique template name
		    WebElement inputField = driver.findElement(By.xpath("(//input[@type=\"text\"])[1]"));
		    inputField.clear();
		    inputField.sendKeys(templateName);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();//select category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[2]")).click();//select 2nd option (marketing) from category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();//select language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[15]")).click();//select 25th option(gujrati) from language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[contains(.,\"Image\")]")).click();//click image
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//label[@for=\"file-upload\"])[1]")).click();
			Robot robot = new Robot();
			StringSelection selection = new StringSelection("C:\\Users\\HP\\Downloads\\Holi test image.jpg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		    
		    // Paste the file path: CTRL+V
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    Thread.sleep(1000);
		    robot.keyPress(KeyEvent.VK_V);
		    Thread.sleep(1000);
		    robot.keyRelease(KeyEvent.VK_V);
		    Thread.sleep(1000);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    Thread.sleep(1000);
		    // Press Enter to confirm the file upload.
		    robot.keyPress(KeyEvent.VK_ENTER);
		    Thread.sleep(1000);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		 bodytext.bodytext();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@placeholder=\"Enter content for {{1}}\"]")).sendKeys("Ifanow");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@placeholder=\"Enter content for {{2}}\"]")).sendKeys("Client");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[4]/div/div/div/textarea")).sendKeys("Sincerely, Ifanow");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Call phone number (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Visit website (2)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Copy offer code (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Custom button (6)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("Call");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("India");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[6]")).sendKeys("+919834549528");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[7]")).sendKeys("Redirect");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type=\"url\"]")).sendKeys("https://my-planner.in/login");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[8]")).sendKeys("Coupon");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[9]")).sendKeys("dhgfhg");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[10]")).sendKeys("Share");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//span[contains(.,\"Create Template\")])[2]")).click();
		 Thread.sleep(1000);		 
	}
}
