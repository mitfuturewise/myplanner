package Swiftchat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class bodytext extends Dashboard {
    
    // Non-static method to remove non-BMP characters
    public String removeNonBMP(String input) {
        return input.codePoints()
                    .filter(cp -> cp <= 0xFFFF)  // Only keep BMP characters
                    .collect(StringBuilder::new,
                             StringBuilder::appendCodePoint,
                             StringBuilder::append)
                    .toString();
    }
    @Test
    // Non-static method that encapsulates the test logic
    public void bodytext() {
        // Initialize ChromeDriver (set the system property if needed)
        
	        String originalText = "Dear {{1}}, {{2}},\r\n"
	        		+ "\r\n"
	        		+ "🚀 Exclusive Investment Opportunity Just for You!\r\n"
	        		+ "\r\n"
	        		+ "Your special offer code OFFER2025 is valid until March 31st!\r\n"
	        		+ "\r\n"
	        		+ "On [SIP Drive Date], I’m organizing SIP Ka Maha Kumbh – an exclusive, once-a-year investment drive! Our goal? 500+ SIPs in a single day!\r\n"
	        		+ "\r\n"
	        		+ "📈 Be part of this financial revolution and take a bold step towards long-term wealth creation!\r\n"
	        		+ "\r\n"
	        		+ "⚡ Limited Time – Only 24 Hours! Secure your spot among the 500 committed investors making a difference.\r\n"
	        		+ "\r\n"
	        		+ "💬 Click below to request a callback and reserve your place!\r\n"
	        		+ "\r\n"
	        		+ "Thank you for trusting us with your investment journey.";
        
        // Remove non-BMP characters
        String filteredText = removeNonBMP(originalText);
        
        // Send the filtered text to the textarea element
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/textarea")).sendKeys(filteredText);
        
    }

}
