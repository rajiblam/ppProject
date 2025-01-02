package testClassPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import basepackage.baseClass;
import pageObjectPackage.SelectCampaignAndVoicePage;
import pageObjectPackage.SelectStationPage;
import pageObjectPackage.agentCallingPage;
import pageObjectPackage.loginPage;

public class SelectCampaignAndVoiceTest extends baseClass{

	SelectStationPage ssp;
	SelectCampaignAndVoicePage objSelectCampaignPage;
	loginPage loginPageObj;
	agentCallingPage callingPage;
	SoftAssert softAssert=new SoftAssert();
	
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
		PPlogin();
		enterValidStationIDAndPassword();
	}
	@AfterMethod
	public void TearDown()
	{
		baseClass.closeBrowser();
	}
	
	public void PPlogin()
	{
		ssp.loginWithValidCredintials(prop.getProperty("validUsername"), prop.getProperty("validPassword"));
	}
	public void enterValidStationIDAndPassword()
	{
		objSelectCampaignPage = ssp.enterStationIdAndPassword(prop.getProperty("validStationID"), prop.getProperty("validStationPassword"));
	}
	
	@Test(priority=1)
	public void VerifySelectCampaignPageCaption()
	{
		String captionStatus=objSelectCampaignPage.verifyCaptionOfSelectVoicepage();
		Assert.assertTrue(captionStatus.contains("Select Voice"));
	}
	@Test(priority=2, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifyBackToStationPage()
	{
		objSelectCampaignPage.validateBackToSelectStationPageOption();
		boolean StationPageCaption = ssp.validatePageCaption();
		Assert.assertTrue(StationPageCaption);
	}
	
	@Test(priority=3, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifySelectNSBCampaignWithoutSelectVoice() throws InterruptedException
	{
		objSelectCampaignPage.selectNSBCampaignWithoutSelectVoice();
		String expectedText=prop.getProperty("CampaignpageErrorText");
		String actualText = driver.findElement(By.xpath(prop.getProperty("CampaignPageErrorTextXpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=4)
	public void VerifySelectNSBCampaignWitSelectVoice() // quit forcefully
	{
		callingPage = objSelectCampaignPage.selectNSBCampaignWithSelectVoice();
		//boolean nameStatus=callingPage.CheckingCampaignName();
		//Assert.assertTrue(nameStatus);
	}
	
	@Test(priority=5, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifyLogoutButtonFunction()
	{
		loginPageObj = objSelectCampaignPage.validateLogoutButtonFunctionlaity();
		boolean loginCaption=loginPageObj.captionLogin();
		Assert.assertTrue(loginCaption);
	}
	
	@Test(priority=6, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifySelectInnovative_QualifiersCampaignWithoutSelectVoice()
	{
		objSelectCampaignPage.selectInnovative_QualifiersCampaignWithoutSelectVoice();
		String expectedText=prop.getProperty("CampaignpageErrorText");
		String actualText = driver.findElement(By.xpath(prop.getProperty("CampaignPageErrorTextXpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	@Test(priority=7, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifySelectInnovative_QualifiersCampaignWithSelectVoice()
	{
		objSelectCampaignPage.selectInnovative_QualifiersCampaignWithSelectVoice();
		//boolean nameStatus=callingPage.CheckingCampaignName();
		//Assert.assertTrue(nameStatus);
	}
	@Test(priority=8, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifyWhatIfMediaHealthCampaignWithOutSelectVoice()
	{
		objSelectCampaignPage.selectWhat_If_Media_health_CampaignWithoutSelectVoice();
		//boolean nameStatus=callingPage.CheckingCampaignName();
		//Assert.assertTrue(nameStatus);
	}
	@Test(priority=9, dependsOnMethods = "VerifySelectCampaignPageCaption")
	public void VerifyWhatIfMediaHealthCampaignWithSelectVoice()
	{
		objSelectCampaignPage.selectWhat_If_Media_health_CampaignWithSelectVoice();
		//boolean nameStatus=callingPage.CheckingCampaignName();
		//Assert.assertTrue(nameStatus);
	}
	
	@Test(priority=10)
	public void VerifyCampaignLIT_ACA_WithVoice()
	{
		objSelectCampaignPage.select_lit_acaCampaignWithVoice();
//		boolean campaignNameStatus = callingPage.CheckingCampaignName();
//		softAssert.assertTrue(campaignNameStatus);
//		softAssert.assertAll();
	}
	@Test(priority=11)
	public void verifyCampaignLIT_CCD_DV_LV_MXWithVoice()
	{
		objSelectCampaignPage.select_Campaign_LIT_CCD_DV_LV_MX_WithVoice();
	}
	@Test(priority=12)
	public void verifyCampaign_LIT_FE_withVoice()
	{
		objSelectCampaignPage.select_LIT_FE_Campaign_WithVoice();
	}
	@Test(priority=13)
	public void verifyCampaign_POSA_Pledge_Assistance_WithVoice()
	{
		objSelectCampaignPage.select_POSA_Pledge_Assistance_CampaignWithVoice();
	}
	@Test(priority=14)
	public void verifyCampaign_Tax_relief_Statement_WithVoice()
	{
		objSelectCampaignPage.select_Tax_Relief_Statement_CampaignWithVoice();
	}
	@Test(priority=15)
	public void verifyCampaign_What_If_Media_Auto_Signals_CampaignWithVoice()
	{
		objSelectCampaignPage.select_What_If_Media_Auto_Signals_Campaign_WithVoice();
	}
}
