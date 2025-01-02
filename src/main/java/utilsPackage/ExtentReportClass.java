package utilsPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import actionsDriver.Action;

public class ExtentReportClass {

	public static ExtentReports generateExtentReport() throws IOException
	{
	ExtentReports extentReport=new ExtentReports();
	File extentReportPath=new File(System.getProperty("user.dir")+"\\Report\\extentReport\\reportExtentTodayNineOct.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
	//ExtentEmailReporter email = new ExtentEmailReporter("Email.html");

	
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("Perfect Pitch Automation Test Report");
	sparkReporter.config().setDocumentTitle("Perfect Pitch Automation Report");
	sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	
	extentReport.attachReporter(sparkReporter);
	
	Properties prop1=new Properties();
	File propFilePath=new File(System.getProperty("user.dir")+"\\src\\main\\java\\utilsPackage\\config.properties");
	FileInputStream fis=new FileInputStream(propFilePath);
	prop1.load(fis);
	
	extentReport.setSystemInfo("Application URL ", prop1.getProperty("url"));
	extentReport.setSystemInfo("Browser", prop1.getProperty("browser"));
	extentReport.setSystemInfo("Login Page Username ", prop1.getProperty("validUsername"));
	extentReport.setSystemInfo("Login Page Password ", prop1.getProperty("validPassword"));
	extentReport.setSystemInfo("Valid Station Name", prop1.getProperty("validStationID"));
	extentReport.setSystemInfo("Valid Station Password", prop1.getProperty("validStationPassword"));
	extentReport.setSystemInfo("OS Name", System.getProperty("os.name"));
	extentReport.setSystemInfo("System Username", System.getProperty("user.name"));
	extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
	
	return extentReport;
	}
	
}
