package actionsDriver;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	
	public static void click(WebDriver driver,WebElement ele)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
	}
	
	public static void type(WebElement ele,String text)
	{
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static String timeStamp()
	{
		Date d=new Date();
		return d.toString().replace(" ", "_").replace(":", "_");
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	


}
