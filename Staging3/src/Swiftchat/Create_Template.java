package Swiftchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Staging3.TestListeners;

@Listeners (TestListeners.class)
public class Create_Template extends Dashboard {
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
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Test");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();//select category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[2]")).click();//select 2nd option (marketing) from category dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();//select language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//li[@role=\"option\"])[25]")).click();//select 25th option(gujrati) from language dropdown
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("હેલો {{1}}");//enter text to header
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("વપરાશકર્તા");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div[1]/div[1]/div/textarea")).sendKeys("પ્રિય {{1}}, [SIP ડ્રાઇવ ડેટ] પર, હું વર્ષમાં એક વાર આવતા SIP કા મહા કુંભ નામના રોકાણ અભિયાનનું આયોજન કરી રહ્યો છું! 🌟 એક દિવસમાં 500+ SIP! આ ઐતિહાસિક સંપત્તિ ચળવળનો ભાગ બનો. 🔥 નાણાકીય સ્વતંત્રતા તરફ એક સાહસિક પગલું ભરતા હજારો રોકાણકારો સાથે જોડાઓ! 📌 મર્યાદિત સમય - ફક્ત 24 કલાક! મારા 500 SIP રોકાણકારોમાંથી એક બનો! 👉 કૉલબેકની વિનંતી કરવા અને તમારી જગ્યા લૉક કરવા માટે નીચે ક્લિક કરો! અમને પસંદ કરવા બદલ આભાર. સાદર, {{2}}");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("ક્લાયન્ટ");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("ઇફાનોવ");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[4]/div/div/div/textarea")).sendKeys("આપની, ઇફાનોવ");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Call phone number (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Visit website (2)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Copy offer code (1)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(.,\"Custom button (6)\")]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@type=\"url\"]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@type=\"text\"])[]")).click();
		 
	}
}
