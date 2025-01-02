package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class agentCallingPage {

	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='National Senior Benefits']")
	private WebElement campaignName;
	
	public agentCallingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean CheckingCampaignName()
	{
		return campaignName.isDisplayed();
	}
}
