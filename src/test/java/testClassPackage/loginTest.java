package testClassPackage;

import java.awt.Point;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import actionsDriver.waitClass;
import basepackage.baseClass;
import pageObjectPackage.SelectStationPage;
import pageObjectPackage.loginPage;


public class loginTest extends baseClass{
	
	loginPage lp;
	SelectStationPage selectstationpage;
	
	@BeforeSuite
	public void launchPropFile() throws IOException
	{
		baseClass.initializePropFile();
	}
	@BeforeMethod
	public void StartBrowser() throws IOException
	{
		baseClass.setUp();
		lp=new loginPage(driver);
	}
	@AfterMethod
	public void TearDown()
	{
		baseClass.closeBrowser();
	}
	@Test(priority=1)
	public void ValidateWithPageTitle()
	{
		String ExpectedTitle="Perfect Pitch";
		String actualPageTitle=lp.ValidatePageTitle();
		Assert.assertEquals(actualPageTitle, ExpectedTitle);
	}
	@Test(priority=2) 
	public void validateLogoVisibility()
	{
		boolean logoPresent=lp.validateLogo();
		Assert.assertTrue(logoPresent); 
	}
	@Test(priority=3)
	public void validateLoginPageCaption()
	{
		boolean captionVisible=lp.captionLogin();
		Assert.assertTrue(captionVisible);
	}
	@Test(priority=4)
	public void passwordViewOptionEnable()
	{
		boolean pwordViewOption=lp.passwordViewEye();
		Assert.assertTrue(pwordViewOption);
	}
	@Test(priority=5)
	public void validateLoginButtonName()
	{
		String actualButtonName=lp.buttonNameValidation();
		String expetedButtonName="LOGIN";
		Assert.assertEquals(actualButtonName, expetedButtonName);
	}
	@Test(priority=6)
	public void loginWithValidUsernameAndPassword()
	{
		selectstationpage = lp.loginUser(prop.getProperty("validUsername"), prop.getProperty("validPassword"));
		boolean isDiplayCaption=selectstationpage.validatePageCaption();
		Assert.assertTrue(isDiplayCaption);
	}
	@Test(priority=7)
	public void loginWithIncorrectUsernameAndValidPassword()
	{
		lp.loginUser(prop.getProperty("incorrectUserName"), prop.getProperty("validPassword"));
		String expectedError="username or password invalid";
		String actualError=lp.validateIncorrectPassword();
		Assert.assertEquals(actualError, expectedError);
	}
	@Test(priority=8)
	public void loginWithValidUsernameAndInvalidPassword()
	{
		lp.loginUser(prop.getProperty("validUsername"), prop.getProperty("InvalidPassword"));
		String expectedError="username or password invalid";
		String actualError=lp.validateIncorrectPassword();
		Assert.assertEquals(actualError, expectedError);
	}
	@Test(priority=9)
	public void loginWithEmptyUsernameAndValidPassword() // Demo failed Test Case
	{
		lp.loginUser("", prop.getProperty("validPassword"));
		String expectedError="Username is required";
		String actualError=lp.validateEmptyUserName();
		Assert.assertEquals(actualError, expectedError);
	}
	@Test(priority=10)
	public void loginWithValidUsernameAndEmptyPassword()
	{
		lp.loginUser(prop.getProperty("validUsername"), "");
		waitClass.impWait(driver,waitClass.impTimeOut);
		String expectedError="Password is required";
		String actualError=lp.validateEmptyPassword();
		Assert.assertEquals(actualError, expectedError);
	}
	
	
}
