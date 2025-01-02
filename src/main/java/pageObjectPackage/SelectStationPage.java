package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsDriver.Action;
import actionsDriver.waitClass;
import basepackage.baseClass;

public class SelectStationPage{
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//h2[text()='Select Server & Station']")
	private WebElement pageCaption;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logoutButtonVisible;
	
	@FindBy(xpath = "//div[@class='login_logo']//img")
	private WebElement omindLogo;
	
	@FindBy(xpath = "//div[@class='mb-3']//img")
	private WebElement PPlogoVisible;
	
	@FindBy(xpath = "//label[text()='Station']//following::input[contains(@placeholder,'slg_291')]")
	private WebElement stationId;
	
	@FindBy(xpath = "//label[text()='Password']//following::div//input[contains(@placeholder,'password')]")
	private WebElement stationPassword;
	
	@FindBy(xpath = "//*[local-name()='svg']")
	private WebElement passwordEyeOption;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;
	
	public SelectStationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithValidCredintials(String uName, String Pword)
	{
		Action.type(username, uName);
		Action.type(password, Pword);
		Action.click(driver, loginBtn);
	}
	
	public boolean validatePageCaption()
	{
		return pageCaption.isDisplayed();
	}
	
	public boolean validateLogoutButton()
	{
		return logoutButtonVisible.isDisplayed();
	}
	
	public boolean validateOmindLogo()
	{
		waitClass.explicitWait(driver, omindLogo,waitClass.expTimeOut);
		return omindLogo.isDisplayed();
	}
	
	public boolean validatePPLogoVisible()
	{
		waitClass.explicitWait(driver, PPlogoVisible,waitClass.expTimeOut);
		return PPlogoVisible.isDisplayed();
	}
	
	public boolean passwordViewOptionEnable()
	{
		return passwordEyeOption.isEnabled();
	}
	
	public SelectCampaignAndVoicePage enterStationIdAndPassword(String UID, String PWD) // create selectCampaign obj
	{
		Action.type(stationId, UID);
		Action.type(stationPassword, PWD);
		Action.click(driver, submitButton);
		return new SelectCampaignAndVoicePage(driver);
	}
	
	public String validateSubmitBtnName()
	{
		waitClass.explicitWait(driver, submitButton, waitClass.expTimeOut);
		return submitButton.getText();
	}
	
	public loginPage validateLogoutBtnFunctionlity()
	{
		logoutButtonVisible.click();
		return new loginPage(driver);
	}
	
}
