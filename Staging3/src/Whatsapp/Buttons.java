package Whatsapp;

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

import Staging3.TestListeners;

	@Listeners(TestListeners.class)
	public class Buttons extends Login {
		public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		public AtomicInteger responseStatus = new AtomicInteger(-1);
		newcampaign createcamp = new newcampaign();
		wfnp wfnp = new wfnp();
	    public final String expectedUrlBase1 = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
		
	    @Test(priority = 1)
		public void waddwebsiteurl() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void waddwebsiteurlbuttontext() throws InterruptedException, AWTException {
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

			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void waddwebsiteurlbuttontextcontent() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void wphonenumber() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void wphonenumberbuttontext() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void wphonenumberbuttontextcontent() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));

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
		public void wquickurl() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
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
		public void wquickurlbuttontextcontent() throws InterruptedException, AWTException {
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
			// Atomic variables for thread-safe response tracking
            AtomicInteger responseStatus = new AtomicInteger(-1);
            AtomicReference<String> expectedRequestId = new AtomicReference<>("");
            AtomicBoolean firstResponseProcessed = new AtomicBoolean(false); // Ensure only first response is used

            // Enable network tracking
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Capture the first request ID
            devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
                String requestUrl = requestEvent.getRequest().getUrl();
                if (requestUrl.startsWith(expectedUrlBase)) {
                    expectedRequestId.set(requestEvent.getRequestId().toString());
                    Reporter.log("Captured expected request ID: " + expectedRequestId.get());
                }
            });

            // Listen for network responses
            devTools.addListener(Network.responseReceived(), responseReceived -> {
                // Process only the first API response received
                if (firstResponseProcessed.get()) {
                    return; // Ignore any second response
                }

                Response res = responseReceived.getResponse();
                String actualUrl = res.getUrl();
                Reporter.log("Processing response from expected URL: " + actualUrl);

                try {
                    // Retrieve the response body
                    var requestId = responseReceived.getRequestId();
                    String body = devTools.send(Network.getResponseBody(requestId)).getBody();
                    Reporter.log("Response Body: " + body);

                    // Parse JSON and extract status field
                    JSONObject jsonResponse = new JSONObject(body);
                    int statusFromBody = jsonResponse.getInt("status");
                    Reporter.log("Status from API response body: " + statusFromBody);

                    responseStatus.set(statusFromBody);
                    firstResponseProcessed.set(true); // Mark first response as processed
                } catch (Exception e) {
                    Reporter.log("Error retrieving/parsing response body: " + e.getMessage());
                }
            });

            // Click the "Next" button to trigger API calls
            driver.findElement(By.xpath("(//span[contains(.,\" NEXT STEP \")])[2]")).click();

            // ✅ **Fixed WebDriverWait to wait until the first response is processed**
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> Boolean.TRUE.equals(firstResponseProcessed.get()));
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
	    public void wtestbuttonsclickwu() throws InterruptedException {
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
	    public void wtestbuttonsclickpn() throws InterruptedException {
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
	    public void wtestbuttonsclickqr() throws InterruptedException {
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