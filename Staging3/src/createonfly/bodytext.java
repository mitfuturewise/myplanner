package createonfly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class bodytext extends Login {
    
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
        
        String originalText = "Dear User,\r\n"
                + "\r\n"
                + "On [SIP Drive Date], I’m hosting a once-in-a-year investment drive called SIP Ka Maha Kumbh!\r\n"
                + "\r\n"
                + "🌟 500+ SIPs in One Day! Be a part of this historic wealth movement.\r\n"
                + "🔥 Join thousands of investors taking a bold step towards financial freedom!\r\n"
                + "📌 Limited window – 24 hours only! Be one of my 500 SIP investors!\r\n"
                + "👉 Click below to request a callback & lock in your spot!\r\n"
                + "\r\n"
                + "Thank you for choosing us.\r\n"
                + "Sincerely,\r\n";
        
        // Remove non-BMP characters
        String filteredText = removeNonBMP(originalText);
        
        // Send the filtered text to the textarea element
        driver.findElement(By.xpath("//textarea[@aria-required='false']")).sendKeys(filteredText);
        
    }

}
