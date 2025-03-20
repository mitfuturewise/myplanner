package createonfly1.copy;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Staging3.TestListeners;

public class devtools extends Login {
	public final String expectedUrlBase = "https://staging.ifanow.in/futurewise/api/v2/web/whatsapp/campaign/create/template/onFly?";
	public AtomicInteger responseStatus = new AtomicInteger(-1);
	public int getResponseStatus() {
        return responseStatus.get();
    }
	public void devtools() {
		TestListeners.setDriver(driver);
		ChromeDriver chromeDriver = (ChromeDriver) driver;
		DevTools devTools = chromeDriver.getDevTools();
		devTools.createSession();

		// Use an AtomicInteger to store the response status code (-1 means not yet set)
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
	}
}
