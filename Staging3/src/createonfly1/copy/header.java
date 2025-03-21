package createonfly1.copy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class header extends Login{
newcampaign createcamp = new newcampaign();
wfnp wfnp = new wfnp();
bodytext bodytext = new bodytext();
private final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
@Test(priority = 1)
public void headerisselectedasnone() throws InterruptedException, AWTException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select text from header dropdown
	Thread.sleep(1000);
}
@Test(priority = 2)
public void textWithoutenteringanytext() throws InterruptedException, AWTException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select text from header dropdown
	Thread.sleep(1000);
//	Actions a = new Actions(driver);
//	Robot r=new Robot();
//	r.keyPress(KeyEvent.VK_CONTROL);
//	Thread.sleep(3000);
//	r.keyPress(KeyEvent.VK_R);
//	Thread.sleep(3000);
//	r.keyRelease(KeyEvent.VK_CONTROL);
//	Thread.sleep(3000);
//	r.keyRelease(KeyEvent.VK_R);
	
}
@Test(priority = 3)
public void testWithFallbackValue() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select text from header dropdown
	 driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[4]"))
     .sendKeys("FallbackValue");
}

@Test(priority = 4)
public void HeaderTextandAddVariable() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//enter text to header dropdown
	 driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[4]"))
     .sendKeys("FallbackValue");
	 driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])[1]")).click();//click on add variable
//	footer.footer();
}
@Test(priority = 5)
public void HeaderTextandAddVariablewithselectdapoint() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//enter text to header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[4]"))
     .sendKeys("FallbackValue");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])[1]")).click();//click on add variable
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"headerPlaceholdervariable\"])")).click();//click to select datapoint
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//click to select 1st datapoint
}
@Test(priority = 6)
public void HeaderTextandAddVariablewithselectdapointandfallbackvalue() throws InterruptedException {
	TestListeners.setDriver(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//enter text to header dropdown
	 Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[4]"))
     .sendKeys("FallbackValue");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//p[contains(.,'Add Variable')])[1]")).click();//click on add variable
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"headerPlaceholdervariable\"])")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//click to select 1st datapoint
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//input[@formcontrolname=\"headerFallbackvalue\"])")).sendKeys("Fallbackvalue");//add text to fallbackvalue
	 //	footer.footer();
}
//@Test(priority = 7)
//public void image() throws InterruptedException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select image option from header dropdown
//	 //	footer.footer();
//	bodytext.bodytext();
//	ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//	// Check if the API response status is 200 before clicking the next button
//    if (responseStatus.get() == 500 || responseStatus.get() == 400) {
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test passed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test failed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
//@Test(priority = 8)
//public void image1() throws InterruptedException, AWTException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select image option from header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("//button[contains(.,\"upload\")]")).click();
//	Robot robot = new Robot();
//	StringSelection selection = new StringSelection("C:\\Users\\HP\\Documents\\ifanow\\whatsapp Apis\\image.jpg");
//    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//    
//    // Paste the file path: CTRL+V
//    robot.keyPress(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    robot.keyPress(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    // Press Enter to confirm the file upload.
//    robot.keyPress(KeyEvent.VK_ENTER);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_ENTER);
//	 //	footer.footer();
//    bodytext.bodytext();
//    ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//    if (responseStatus.get() == 500 || responseStatus.get() == 400) {
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test failed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test passed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
//@Test(priority = 9)
//public void video() throws InterruptedException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).click();//select image option from header dropdown
//	 //	footer.footer();
//	bodytext.bodytext();
//	ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//
//	// Check if the API response status is 200 before clicking the next button
//    if (responseStatus.get() == 500 || responseStatus.get() == 400) {
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test passed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test failed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
//@Test(priority = 10)
//public void video1() throws InterruptedException, AWTException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[4]")).click();//select video option from header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("//button[contains(.,\"upload\")]")).click();
//	Robot robot = new Robot();
//	StringSelection selection = new StringSelection("C:\\Users\\HP\\Documents\\ifanow\\whatsapp Apis\\Video.mp4");
//    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//    
//    // Paste the file path: CTRL+V
//    robot.keyPress(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    robot.keyPress(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    // Press Enter to confirm the file upload.
//    robot.keyPress(KeyEvent.VK_ENTER);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_ENTER);
//	 //	footer.footer();
//    bodytext.bodytext();
//    ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//    if (responseStatus.get() == 500 || responseStatus.get() == 400){
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test failed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test passed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
//@Test(priority = 11)
//public void document() throws InterruptedException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[5]")).click();//select image option from header dropdown
//	 //	footer.footer();
//	bodytext.bodytext();
//	ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//    if (responseStatus.get() == 500 || responseStatus.get() == 400) {
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test passed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test failed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
//@Test(priority = 12)
//public void document1() throws InterruptedException, AWTException {
//	TestListeners.setDriver(driver);
//	wfnp.whatsapp();
//	Thread.sleep(1000);
//	createcamp.newCampaign();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.findElement(By.xpath("(//mat-select[@aria-disabled='false'])[2]")).click();//select header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[5]")).click();//select video option from header dropdown
//	Thread.sleep(1000);
//	driver.findElement(By.xpath("//button[contains(.,\"upload\")]")).click();
//	Robot robot = new Robot();
//	StringSelection selection = new StringSelection("C:\\Users\\HP\\Documents\\ifanow\\whatsapp Apis\\document.pdf");
//    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//    
//    // Paste the file path: CTRL+VC:\Users\HP\Documents\ifanow\whatsapp Apis\document.pdf
//    
//    
//    robot.keyPress(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    robot.keyPress(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_V);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_CONTROL);
//    Thread.sleep(1000);
//    // Press Enter to confirm the file upload.
//    robot.keyPress(KeyEvent.VK_ENTER);
//    Thread.sleep(1000);
//    robot.keyRelease(KeyEvent.VK_ENTER);
//	 //	footer.footer();
//    bodytext.bodytext();
//    ChromeDriver chromeDriver = (ChromeDriver) driver;
//	DevTools devTools = chromeDriver.getDevTools();
//	devTools.createSession();
//
//	// Use an AtomicInteger to store the response status code (-1 means not yet set)
//	// Atomic variables for thread-safe response tracking
//    AtomicInteger responseStatus = new AtomicInteger(-1);
//    AtomicReference<String> expectedRequestId = new AtomicReference<>("");
//    AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used
//
//    // Enable network tracking
//    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//    // Capture the first request ID
//    devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
//        String requestUrl = requestEvent.getRequest().getUrl();
//        if (requestUrl.startsWith(expectedUrlBase)) {
//            expectedRequestId.set(requestEvent.getRequestId().toString());
//            Reporter.log("Captured expected request ID: " + expectedRequestId.get());
//        }
//    });
//
//    // Listen for network responses
//    devTools.addListener(Network.responseReceived(), responseReceived -> {
//        // Process only the first API response received
//        if (firstResponseProcessed.get()) {
//            return; // Ignore any second response
//        }
//
//        Response res = responseReceived.getResponse();
//        String actualUrl = res.getUrl();
//        Reporter.log("Processing response from expected URL: " + actualUrl);
//
//        try {
//            // Retrieve the response body
//            var requestId = responseReceived.getRequestId();
//            String body = devTools.send(Network.getResponseBody(requestId)).getBody();
//            Reporter.log("Response Body: " + body);
//
//            // Parse JSON and extract status field
//            JSONObject jsonResponse = new JSONObject(body);
//            int statusFromBody = jsonResponse.getInt("status");
//            Reporter.log("Status from API response body: " + statusFromBody);
//
//            responseStatus.set(statusFromBody);
//            firstResponseProcessed.set(true); // Mark first response as processed
//        } catch (Exception e) {
//            Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
//        }
//    });
//
//    // Click the "Next" button to trigger API calls
//    driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();
//
//    // ✅ **Fixed WebDriverWait to wait until the first response is processed**
//    new WebDriverWait(driver, Duration.ofSeconds(30))
//        .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
//    if (responseStatus.get() == 500 || responseStatus.get() == 400) {
////	    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//		 Reporter.log("Test failed");
//		 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
//	} else {
//		 Reporter.log("Test passed: " + responseStatus.get());
//		 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
//		 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
//	}	
//}
}
