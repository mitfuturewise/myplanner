package Myplanner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TestListeners implements ITestListener {
	public static WebDriver driver;
	

    // Static setter for the driver
    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }
	@Override
	public void onTestStart(ITestResult result) {//onTestStart:-If the test script is start then the program inside this will be executed.
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {//onTestSuccess: If the test script is successfully executed then whatever code write here will be executed.
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		if (driver != null) {
            try {
                TakesScreenshot t = (TakesScreenshot) driver;
                String name = result.getName();
                File src = t.getScreenshotAs(OutputType.FILE);
                File dest = new File("./Screenshots/" + name + ".png");
                Files.copy(src, dest);
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Driver is null; cannot take screenshot.");
        }
    }


	@Override
	public void onTestSkipped(ITestResult result) {//used when if we want to skipped any test script
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//use when we want to get percentage of success test script till last execution
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {//use when we want to get know if test script is failed due to timeout.
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
}
