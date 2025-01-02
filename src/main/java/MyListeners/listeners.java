package MyListeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import actionsDriver.Action;
import basepackage.baseClass;
import utilsPackage.ExtentReportClass;
import utilsPackage.TakesScreenshotClass;

public class listeners extends baseClass implements ITestListener{

	ExtentReports extendRepObj;
	ExtentTest extentTest;
	String testName;
	@Override
	public void onStart(ITestContext context) {
		
		try {
				extendRepObj = ExtentReportClass.generateExtentReport();
			} 
		catch (Throwable e) 
			{

				e.printStackTrace();
			}
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
		extentTest = extendRepObj.createTest(testName);
		extentTest.log(Status.INFO, testName+"Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, testName+" - Successfully Passed TestCase");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		 // capture driver from the fail test class
//			WebDriver driver=null;
//			try {
//				driver = (WebDriver)result.getTestClass().getRealClass()
//					.getDeclaredField("driver").get(result.getInstance());
//			} 
//			catch (Throwable e) 
//			{
//				e.printStackTrace();
//			}
		
		String rootPath = TakesScreenshotClass.takesScreenShot(driver, result);
		
		//taking screenshot from the path
		extentTest.addScreenCaptureFromPath(rootPath+"//Screenshots//"+result.getName()+".png");
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL, testName + " - Got Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " - Skipped test cases");
	}

	@Override
	public void onFinish(ITestContext context) {
		extendRepObj.flush();
		//open report after complete test execution automatically
		String rootPath=System.getProperty("user.dir")+"\\Report\\extentReport\\reportExtentTodayNineOct.html";
		File extentReportPath=new File(rootPath);
		
		try {
			Desktop.getDesktop().browse(extentReportPath.toURI());
			}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	
}
