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
        
        String originalText = "પ્રિય {{1}}, [SIP ડ્રાઇવ ડેટ] પર, હું વર્ષમાં એક વાર આવતા SIP કા મહા કુંભ નામના રોકાણ અભિયાનનું આયોજન કરી રહ્યો છું! 🌟 એક દિવસમાં 500+ SIP! આ ઐતિહાસિક સંપત્તિ ચળવળનો ભાગ બનો. 🔥 નાણાકીય સ્વતંત્રતા તરફ એક સાહસિક પગલું ભરતા હજારો રોકાણકારો સાથે જોડાઓ! 📌 મર્યાદિત સમય - ફક્ત 24 કલાક! મારા 500 SIP રોકાણકારોમાંથી એક બનો! 👉 કૉલબેકની વિનંતી કરવા અને તમારી જગ્યા લૉક કરવા માટે નીચે ક્લિક કરો! અમને પસંદ કરવા બદલ આભાર. સાદર, {{2}}";
        
        // Remove non-BMP characters
        String filteredText = removeNonBMP(originalText);
        
        // Send the filtered text to the textarea element
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/textarea")).sendKeys(filteredText);
        
    }

}
