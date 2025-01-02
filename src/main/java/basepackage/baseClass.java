package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import actionsDriver.waitClass;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public static void initializePropFile() throws IOException
	{
		String rootPath=System.getProperty("user.dir");
		InputStream fis=new FileInputStream(rootPath+"\\src\\main\\java\\utilsPackage\\config.properties");
		prop=new Properties();
		prop.load(fis);
	}
	
	public static void setUp()
	{
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//FirefoxOptions fOp=new FirefoxOptions();
			//fOp.addArguments("--headless=new");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitClass.pageLoadTimeOut(driver, waitClass.pageLoadTimeOut);;
		waitClass.impWait(driver,waitClass.impTimeOut);
	}
	
	public static void closeBrowser()
	{
		driver.close();
		
	}
	
}
