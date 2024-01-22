package Com.Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners extends Commons implements ITestListener {
	
	ExtentReports report = Commons.GetExtendReports();
	ExtentTest test;
	
	//static Base b = new Base();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String TestName = result.getName();
		
	    test = report.createTest(TestName);
	    
	    test.log(Status.INFO, TestName+" Excecution Started");
	    
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {

		String Testname = result.getName();
		
		test.log(Status.INFO, Testname+" got Successfully Executed");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {

		String TestName = result.getName();
		
		test.log(Status.FAIL, TestName+" Test Case is Failed");
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriver driver = this.driver;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		
		}
		try {
			test.addScreenCaptureFromPath(TakeScreenShots(driver), TestName);
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String Testname = result.getName();
		
		test.log(Status.SKIP, "The Test case Or Skiped" );
		
	}

	
	@Override
	public void onFinish(ITestContext context) {

		report.flush();
		
	}


}



