package pageObjectPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsDriver.Action;
import basepackage.baseClass;

public class loginPage {
	
	public WebDriver driver;

	@FindBy(xpath = "//div[@class='login_bg p-4 text-center']/img")
	private WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//h2[text()='Login']")
	private WebElement captionLogin;
	
	@FindBy(xpath = "//*[local-name()='svg']")
	private WebElement passwordViewOption;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnName;
	
	@FindBy(xpath = "//div[text()='username or password invalid']")
	private WebElement incorrectPasswordError;
	
	@FindBy(xpath = "//div[text()='Username is required']")
	private WebElement emptyUserNameError;
	
	@FindBy(xpath = "//div[text()='Password is required']")
	private WebElement emptyPasswordError;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public String ValidatePageTitle()
	{
		String actualTitle =driver.getTitle();
		return actualTitle;
	}
	
	public SelectStationPage loginUser(String uName,String PWord)
	{
		Action.type(username, uName);
		Action.type(password, PWord);
		Action.click(driver, loginBtn);
		return new SelectStationPage(driver);
	}
	
	public boolean captionLogin()
	{
		return captionLogin.isDisplayed();
	}
	
	public boolean passwordViewEye()
	{
		return passwordViewOption.isEnabled();
	}
	
	public String buttonNameValidation()
	{
		return btnName.getText();
	}
	
	public String validateIncorrectPassword()
	{
		String errorText=incorrectPasswordError.getText();
		return errorText;
	}
	
	public String validateEmptyUserName()
	{
		String emptyUsernameErrorText=emptyUserNameError.getText();
		return emptyUsernameErrorText;
	}
	
	public String validateEmptyPassword()
	{
		String emptyPasswordErrorText=emptyPasswordError.getText();
		return emptyPasswordErrorText;
	}
}
