package testClassPackage;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actionsDriver.waitClass;
import basepackage.baseClass;
import pageObjectPackage.SelectCampaignAndVoicePage;
import pageObjectPackage.SelectStationPage;
import pageObjectPackage.loginPage;
import utilsPackage.DataProvidertoPP;

public class SelectStationTest extends baseClass {

	SelectStationPage ssp;
	SelectCampaignAndVoicePage campaignVoicepage;
	
	@BeforeSuite
	public void launchPropFile() throws IOException
	{
		baseClass.initializePropFile();
	}
	@BeforeMethod
	public void StartBrowser() throws IOException
	{
		baseClass.setUp();
		ssp=new SelectStationPage(driver);
		login();
	}
	@AfterMethod
	public void TearDown()
	{
		baseClass.closeBrowser();
	}
	public void login()
	{
		ssp.loginWithValidCredintials(prop.getProperty("validUsername"), prop.getProperty("validPassword"));
	}
	
	//Date Provider Start*******************************
	
	@DataProvider(name = "ValidStationIDAndPassword")
	public Object[][] supplyDataToStationPage() throws IOException
	{
		Object data[][]=DataProvidertoPP.getDataFromExcel("StationPasswordValid");
		return data;
	}
	@DataProvider(name = "InvalidStationIDAndValidPassword")
	public Object[][] supplyDataToStationPage2() throws IOException
	{
		Object data[][]=DataProvidertoPP.getDataFromExcel("StationInvalid_PasswordValid");
		return data;
	}
	@DataProvider(name = "ValidStationIDAndInvalidPassword")
	public Object[][] supplyDataToStationPage3() throws IOException
	{
		Object data[][]=DataProvidertoPP.getDataFromExcel("StationValid_Password_Invalid");
		return data;
	}
	@DataProvider(name = "InvalidStationIDAndInvalidPassword")
	public Object[][] supplyDataToStationPage4() throws IOException
	{
		Object data[][]=DataProvidertoPP.getDataFromExcel("StationInvalid_PasswordInvalid");
		return data;
	}
	
	// Data provider end***********************************
	
	@Test(priority=1)
	public void validatePageCaption()
	{
		boolean isDisplayPageCaption=ssp.validatePageCaption();
		Assert.assertTrue(isDisplayPageCaption);
	}
	@Test(priority=2, dependsOnMethods = "validatePageCaption")
	public void validateOmindLogo()
	{
		boolean visibleOmindLogo=ssp.validateOmindLogo();
		Assert.assertTrue(visibleOmindLogo);
	}
	@Test(priority=3, dependsOnMethods = "validatePageCaption")
	public void validatePPLogo()
	{
		boolean ppLogovisible=ssp.validatePPLogoVisible();
		Assert.assertTrue(ppLogovisible);
	}
	@Test(priority=4, dependsOnMethods = "validatePageCaption")
	public void validateLogoutButton()
	{
		boolean logOutButtonVisible=ssp.validateLogoutButton();
		Assert.assertTrue(logOutButtonVisible);
	}
	@Test(priority=5, dependsOnMethods = "validatePageCaption")
	public void passwordViewOption()
	{
		boolean pWordViewOpt=ssp.passwordViewOptionEnable();
		Assert.assertTrue(pWordViewOpt);
	}
	//demo for data-driven testing 
	@Test(priority=6, dependsOnMethods = "validatePageCaption",dataProvider = "ValidStationIDAndPassword")
	public void enterValidStationIDAndPassword(String userName, String passWord)
	{
		campaignVoicepage = ssp.enterStationIdAndPassword(userName, passWord);
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualText=campaignVoicepage.verifyCaptionOfSelectVoicepage();
		String expectedText="Select Voice";
		Assert.assertEquals(actualText, expectedText);
	}
	//demo end
	@Test(priority=7, dependsOnMethods = "validatePageCaption", dataProvider = "InvalidStationIDAndValidPassword")
	public void validateInvalidStationIdAndValidPassword(String uName, String Pword)
	{
		ssp.enterStationIdAndPassword(uName, Pword);
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualError=driver.findElement(By.xpath(prop.getProperty("stationIDErrorXpath"))).getText();
		String expectedError=prop.getProperty("stationIDExpectedErrortext");
		Assert.assertEquals(actualError, expectedError);
	}
	@Test(priority=8, dependsOnMethods = "validatePageCaption", dataProvider = "ValidStationIDAndInvalidPassword")
	public void validateValidStationIdAndInvalidPassword(String username, String password)
	{
		ssp.enterStationIdAndPassword(username, password);
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualError=driver.findElement(By.xpath(prop.getProperty("stationPasswordErrorXpath"))).getText();
		String expectedError=prop.getProperty("stationPasswordErrorText");
		Assert.assertEquals(actualError, expectedError);
	}
	@Test(priority=9, dependsOnMethods = "validatePageCaption", dataProvider = "InvalidStationIDAndInvalidPassword")
	public void validateInvalidStationIdAndInvalidPassword(String username, String password)
	{
		ssp.enterStationIdAndPassword(username, password);
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualErrorText=driver.findElement(By.xpath(prop.getProperty("stationIDErrorXpath"))).getText();
		String expectedErrorText=prop.getProperty("stationIDExpectedErrortext");
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	@Test(priority=10, dependsOnMethods = "validatePageCaption")
	public void validateEmptyStationIdAndEmptyPassword()
	{
		ssp.enterStationIdAndPassword("", "");
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualErrorText=driver.findElement(By.xpath(prop.getProperty("emptyStationXpath"))).getText();
		String expectedErrorText=prop.getProperty("emptyStationText");
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	@Test(priority=11, dependsOnMethods = "validatePageCaption")
	public void validateEmptyStationIdAndValidStationPassword()
	{
		ssp.enterStationIdAndPassword("", prop.getProperty("validStationPassword"));
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualText=driver.findElement(By.xpath(prop.getProperty("emptyStationXpath"))).getText();
		String expectedText=prop.getProperty("emptyStationText");
		Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=12, dependsOnMethods = "validatePageCaption")
	public void validateValidStationIdAndEmptyStationPassword()
	{
		ssp.enterStationIdAndPassword(prop.getProperty("validStationID3"), "");
		waitClass.impWait(driver, waitClass.impTimeOut);
		String actualText=driver.findElement(By.xpath(prop.getProperty("emptyPasswordXpath"))).getText();
		String expectedText=prop.getProperty("emptyPasswordText");
		Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=13, dependsOnMethods = "validatePageCaption")
	public void validateSubmitButtonName()
	{
		String actualName=ssp.validateSubmitBtnName();
		String expName="Submit";
		Assert.assertTrue(actualName.equalsIgnoreCase(expName));
	}
	@Test(priority=14, dependsOnMethods = "validatePageCaption")
	public void validateLogoutButtonFunctionlity()
	{
		loginPage loginpage = ssp.validateLogoutBtnFunctionlity();
		boolean loginCaptionStatus=loginpage.captionLogin();
		Assert.assertTrue(loginCaptionStatus);
	}
}
