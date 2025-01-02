package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actionsDriver.Action;
import actionsDriver.waitClass;

public class SelectCampaignAndVoicePage {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[text()=' Back']")
	private WebElement backOption;
	
	@FindBy(xpath="//h2[text()='Select Voice']")
	private WebElement selectVoiceCaption;
	
	@FindBy (xpath = "//div[text()='Logout']")
	private WebElement logOutButton;
	
	@FindBy (xpath = "//div//img[@src='images/login_user_asbtract.svg']")
	private WebElement ppLogo;
	
	@FindBy(xpath="//label[text()='Campaign']//following::div[contains(@class,'formControl')]")
	private WebElement campaignNameDropDown;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='demo']")
	private WebElement demoCampaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='national-senior-benefits']")
	private WebElement NSBCampaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='innovative-qualifiers']")
	private WebElement innovativeCampaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='lit-aca']")
	private WebElement lit_acaCampaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='lit-ccd-dv-lv-mx']")
	private WebElement lit_ccd_dv_lv_mxCampaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='lit-fe']")
	private WebElement lit_fe_Campaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='posa-pledge-assistance']")
	private WebElement posa_pledge_assistance_Campaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='tax-relief-settlement']")
	private WebElement tax_relief_settlement_Campaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='what-if-media-auto-signals']")
	private WebElement what_if_media_auto_signals_Campaign;
	
	@FindBy(xpath = "//div//child::ul//li[@data-value='what-if-media-health-insurance']")
	private WebElement what_if_media_health_insurance_Campaign;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//h3[text()='Crystal']//preceding::input[@class='radio']")
	private WebElement NSBcrystalRadioButton;
	
	@FindBy(xpath = "//h3[text()='Isaac']//parent::div//preceding-sibling::input")
	private WebElement isaacVoiceInnovation_Qualifier;
	
	@FindBy(xpath = "//h3[text()='Crystal']//parent::div//preceding-sibling::input")
	private WebElement whatIfHealthCrystalVoice;
	
	@FindBy(xpath = "//h3[text()='Sarah']//parent::div//preceding-sibling::input")
	private WebElement litAcaCampaignSarahVoice;
	
	@FindBy(xpath = "//h3[text()='Crystal']//parent::div//preceding-sibling::input")
	private WebElement LIT_CCD_DV_LV_MX;
	
	@FindBy(xpath = "//h3[text()='Sarah']//parent::div//preceding-sibling::input")
	private WebElement campaign_LIT_FE_SarahVoice;
	
	@FindBy(xpath = "//h3[text()='Roy']//parent::div//preceding-sibling::input")
	private WebElement campaign_POSA_Pledge_Assistance;
	
	@FindBy(xpath = "//h3[text()='Sarah']//parent::div//preceding-sibling::input")
	private WebElement campaign_Tax_Relief_Statement_Sarah_Voice;
	
	@FindBy(xpath = "//h3[text()='Kallie']//parent::div//preceding-sibling::input")
	private WebElement campaign_What_If_Media_Auto_Signals_Voice_kallie;
	
	//constructor open ************
	public SelectCampaignAndVoicePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//constructor closed****************
	
	public void validateBackToSelectStationPageOption()
	{
		Action.click(driver, backOption);
	}
	
	public String verifyCaptionOfSelectVoicepage()
	{
		String captionText=selectVoiceCaption.getText();
		return captionText;
	}
	
	public loginPage validateLogoutButtonFunctionlaity()
	{
		Action.click(driver, logOutButton);
		return new loginPage(driver);
	}
	
	public void selectNSBCampaignWithoutSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, NSBCampaign);
		Action.click(driver, continueButton);
	}
	
	public agentCallingPage selectNSBCampaignWithSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, NSBCampaign);
		waitClass.explicitWait(driver, NSBcrystalRadioButton, waitClass.expTimeOut);
		Action.click(driver, NSBcrystalRadioButton);
		Action.click(driver, continueButton);
		return new agentCallingPage(driver);
	}
	
	public void select_lit_acaCampaignWithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, lit_acaCampaign);
		waitClass.explicitWait(driver, NSBcrystalRadioButton, waitClass.expTimeOut);
		Action.click(driver, litAcaCampaignSarahVoice);
		Action.click(driver, continueButton);
	}
	
	public void select_Campaign_LIT_CCD_DV_LV_MX_WithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, lit_ccd_dv_lv_mxCampaign);
		waitClass.explicitWait(driver, LIT_CCD_DV_LV_MX, waitClass.expTimeOut);
		Action.click(driver, LIT_CCD_DV_LV_MX);
		Action.click(driver, continueButton);
	}
	
	public void selectInnovative_QualifiersCampaignWithoutSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, innovativeCampaign);
		Action.click(driver, continueButton);
	}
	
	public void selectInnovative_QualifiersCampaignWithSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, innovativeCampaign);
		waitClass.explicitWait(driver, whatIfHealthCrystalVoice, waitClass.expTimeOut);
		Action.click(driver, isaacVoiceInnovation_Qualifier);
		Action.click(driver, continueButton);
	}
	
	public void select_LIT_FE_Campaign_WithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, lit_fe_Campaign);
		waitClass.explicitWait(driver, whatIfHealthCrystalVoice, waitClass.expTimeOut);
		Action.click(driver, campaign_LIT_FE_SarahVoice);
		Action.click(driver, continueButton);
	}
	
	public void selectWhat_If_Media_health_CampaignWithoutSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, what_if_media_health_insurance_Campaign);
		Action.click(driver, continueButton);
	}
	
	public void selectWhat_If_Media_health_CampaignWithSelectVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, what_if_media_health_insurance_Campaign);
		waitClass.explicitWait(driver, whatIfHealthCrystalVoice, waitClass.expTimeOut);
		Action.click(driver, whatIfHealthCrystalVoice);
		Action.click(driver, continueButton);
	}
	
	public void select_POSA_Pledge_Assistance_CampaignWithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, posa_pledge_assistance_Campaign);
		waitClass.explicitWait(driver, campaign_POSA_Pledge_Assistance, waitClass.expTimeOut);
		Action.click(driver, campaign_POSA_Pledge_Assistance);
		Action.click(driver, continueButton);
	}
	
	public void select_Tax_Relief_Statement_CampaignWithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, tax_relief_settlement_Campaign);
		waitClass.explicitWait(driver, campaign_Tax_Relief_Statement_Sarah_Voice, waitClass.expTimeOut);
		Action.click(driver, campaign_Tax_Relief_Statement_Sarah_Voice);
		Action.click(driver, continueButton);
	}
	
	public void select_What_If_Media_Auto_Signals_Campaign_WithVoice()
	{
		Action.click(driver, campaignNameDropDown);
		Action.click(driver, what_if_media_auto_signals_Campaign);
		waitClass.explicitWait(driver, campaign_What_If_Media_Auto_Signals_Voice_kallie, waitClass.expTimeOut);
		Action.click(driver, campaign_What_If_Media_Auto_Signals_Voice_kallie);
		Action.scrollDown(driver);
		Action.click(driver, continueButton);
	}
}
