package utilsPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import actionsDriver.Action;

public class TakesScreenshotClass {
	
		
	public static String takesScreenShot(WebDriver driver, ITestResult result)
	{		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String rootPath=System.getProperty("user.dir");
		File des=new File(rootPath+"//Screenshot//"+result.getName()+Action.timeStamp()+".png");
		try {
			FileUtils.copyFile(src, des);
			} catch (Throwable e)
			{
			e.printStackTrace();
			}
		return rootPath;
	}

}
