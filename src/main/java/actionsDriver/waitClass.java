package actionsDriver;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.baseClass;

public class waitClass extends baseClass {
	
	public static final int impTimeOut=50;
	public static final int expTimeOut=10;
	public static final int fluTimeOut=20;
	public static final int pageLoadTimeOut=50;
	
	public static void impWait(WebDriver driver,int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public static void explicitWait(WebDriver driver, WebElement ele, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void fluentWait(WebDriver driver, WebElement ele, int timeOut)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}

}
