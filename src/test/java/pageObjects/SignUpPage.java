package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
	public SignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder=\"Name\"]")
	WebElement name;
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	WebElement email;
	@FindBy(xpath="//button[normalize-space()=\"Signup\"]")
	WebElement btnSigUp;
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginEmail;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement loginPassward;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;

	public void setName(String fname)
	{
		name.sendKeys(fname);
	}
	public void setEmail(String femail)
	{
		email.sendKeys(femail);
	}
	public void clickbtnSigUp()
	{
		btnSigUp.click();
	}
	public void setloginEmail(String email)
	{
		loginEmail.sendKeys(email);
	}
	public void setloginPassward(String pass)
	{
		loginPassward.sendKeys(pass);
	}
	public void clickbtnLogin()
	{
		btnLogin.click();
		
	}
}
