package Whatsapp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Optional;
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

import Staging3.TestListeners;

	@Listeners(TestListeners.class)
	public class Buttons extends Login {
		public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		public AtomicInteger responseStatus = new AtomicInteger(-1);
		newcampaign createcamp = new newcampaign();
		wfnp wfnp = new wfnp();
	    public final String expectedUrlBase1 = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		
	    @Test(priority = 1)
		public void addwebsiteurl() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Passed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Failed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 2)
		public void addwebsiteurlbuttontext() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("URL");
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Passed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Failed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 3)
		public void addwebsiteurlbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("URL");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"url\"])[1]")).sendKeys("https://my-planner.in/login");
			Thread.sleep(1000);
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Failed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Passed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 4)
		public void phonenumber() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Passed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test failed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 5)
		public void phonenumberbuttontext() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("Call");//enter text
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Passed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test failed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 6)
		public void phonenumberbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select phonenumber
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])[1]")).sendKeys("Call");//enter text
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"phone\"])[1]")).sendKeys("9834549528");
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Failed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Passed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 7)
		public void quickurl() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select quickreplybutton
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500) {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Passed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Failed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 8)
		public void quickurlbuttontextcontent() throws InterruptedException, AWTException {
			TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select quickreplybutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@formcontrolname=\"buttonText\"])")).sendKeys("QuickReply");
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();

			// Use an AtomicInteger to store the response status code (-1 means not yet set)
			AtomicInteger responseStatus = new AtomicInteger(-1);
			 AtomicReference<String> expectedRequestId = new AtomicReference<>("");

		     // Enable network tracking
		     devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		     // Capture the request ID when the expected API call is sent
		     devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
		         String requestUrl = requestEvent.getRequest().getUrl();
		         if (requestUrl.startsWith(expectedUrlBase)) {
		             expectedRequestId.set(requestEvent.getRequestId().toString());
		             Reporter.log("Captured expected request ID: " + expectedRequestId.get());
		         }
		     });

		     // Listen for network responses
		     devTools.addListener(Network.responseReceived(), responseReceived -> {
		         // Process only if this response belongs to our expected request
		         if (!responseReceived.getRequestId().toString().equals(expectedRequestId.get())) {
		             return;
		         }
		         Response res = responseReceived.getResponse();
		         String actualUrl = res.getUrl();
		         Reporter.log("Processing response from expected URL: " + actualUrl);
		         try {
		             // Retrieve the response body using the request ID from the event
		             var requestId = responseReceived.getRequestId();
		             String body = devTools.send(Network.getResponseBody(requestId)).getBody();
		             Reporter.log("Response Body: " + body);
		             // Parse the JSON and extract the "status" field
		             JSONObject jsonResponse = new JSONObject(body);
		             int statusFromBody = jsonResponse.getInt("status");
		             Reporter.log("Status from API response body: " + statusFromBody);
		             responseStatus.set(statusFromBody);
		         } catch (Exception e) {
		        	 Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
		         }
		     });

			// Click the "Next" button to trigger the API call
			driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

			// Wait until the API response for the expected URL is received (responseStatus != -1)
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(d -> responseStatus.get() != -1);

			// Check if the API response status is 200 before clicking the next button
			if (responseStatus.get() == 500)	 {
//			    driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
				 Reporter.log("Test Failed: API returned 500 when fallback value was provided.");
				 driver.findElement(By.xpath("//i[contains(.,\" clear \")]")).click();
			} else {
				 Reporter.log("Test Passed: " + responseStatus.get());
				 driver.findElement(By.xpath("(//button[@type=\"undefined\"])[2]")).click();
				 driver.findElement(By.xpath("//span[@class=\"textZindex\"]")).click();
			}	
		
		}
	    @Test(priority = 9)
	    public void testbuttonsclickwu() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[1]")).click();//select websiteurlbutton			
	    }
	    @Test(priority = 10)
	    public void testbuttonsclickpn() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();//select websiteurlbutton
	    }
	    @Test(priority =11)
	    public void testbuttonsclickqr() throws InterruptedException {
	    	TestListeners.setDriver(driver);
			wfnp.whatsapp();
			createcamp.newCampaign();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//mat-select[@formcontrolname=\"selectedButtonType\"])")).click();//click on dropdown of buttons
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[3]")).click();//select websiteurlbutton
	    }
}
