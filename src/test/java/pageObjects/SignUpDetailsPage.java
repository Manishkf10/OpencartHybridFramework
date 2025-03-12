package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpDetailsPage extends BasePage{
	public SignUpDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id=\"id_gender1\"]")
	WebElement title;
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement passwrd;
	@FindBy(xpath="//select[@id=\"days\"]")
	WebElement dayDOB;
	@FindBy(xpath="//select[@id=\"months\"]")
	WebElement monthDOB;
	@FindBy(xpath="//select[@id=\"years\"]")
	WebElement yearDOB;
	@FindBy(xpath="//input[@id='first_name']") 
	WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastName;
	@FindBy(xpath="//input[@id=\"company\"]") 
	WebElement company;
	@FindBy(xpath="//input[@id=\"address1\"]")
	WebElement address;
	@FindBy(xpath="//select[@id=\"country\"]")
	WebElement country;
	@FindBy(xpath="//input[@id=\"state\"]")
	WebElement state;
	@FindBy(xpath="//input[@id=\"city\"]")
	WebElement city;
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipcode;
	@FindBy(xpath="//input[@id=\"mobile_number\"]")
	WebElement mobileNumber;
	@FindBy(xpath="//button[normalize-space()=\"Create Account\"]")
	WebElement createAccount;
	
	public void setTitle()
	{
		title.click();
	}
	public void setPassword(String pass)
	{
		passwrd.sendKeys(pass);
	}
	public void setfirstName(String fisrtName)
	{
		firstName.sendKeys(fisrtName);
	}
	public void setlastName(String lstName)
	{
		lastName.sendKeys(lstName);
	}
	public void setcompany(String cmpn)
	{
		company.sendKeys(cmpn);
	}
	public void setaddress(String add)
	{
		address.sendKeys(add);
	}
	public void setmobileNumber(String phone)
	{
		mobileNumber.sendKeys(phone);
	}
	public void setDayDOB(String day)
	{
		dayDOB.click();
		List<WebElement> opt= driver.findElements(By.xpath("//select[@id='days']/option"));
		
		for(WebElement lable:opt)
		{
			if(lable.getText().equals(day))
			{
				lable.click();
			}
		
		}
	}
	public void setMnthDOM(String mnth)
	{
		monthDOB.click();
List<WebElement> opt= driver.findElements(By.xpath("//select[@id='months']/option"));
		
		for(WebElement lable:opt)
		{
			if(lable.getText().equals(mnth))
			{
				lable.click();
			}
		
		}
		
	}
	public void setyearDOB(String year)
	{
		yearDOB.click();
List<WebElement> opt= driver.findElements(By.xpath("//select[@id='years']/option"));
		
		for(WebElement lable:opt)
		{
			if(lable.getText().equals(year))
			{
				lable.click();
			}
		
		}
		
	}
	
	public void scetstate(String st)
	{
		state.sendKeys(st);
	}
	public void setcity(String cty)
	{
		city.sendKeys(cty);
	}
	public void setzipcode(String zip)
	{
		zipcode.sendKeys(zip);
	}
	
	public void btnCreatAc()
	{
		createAccount.click();
	}
	
	

}
