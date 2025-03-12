package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginedPage extends BasePage{
	public LoginedPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='shop-menu pull-right']/child::*/child::li[10]")
	WebElement confLogin;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement btnLogOut;
	
	
	public boolean confirmLogin()
	{
		try
		{
			return confLogin.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickbtnLogOut()
	{
		btnLogOut.click();
	}

}
