package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginedPage;
import pageObjects.SignUpPage;

public class TC002_LoginTest extends BaseTest{

	@Test(groups= {"Regression","Master"})
	
	public void VerfyLogin()
	{
		logger.info("**sTARTING LOGIN TEST**");
		HomePage hp= new HomePage(driver);
		hp.clickSignUP();
		logger.info("**login page**");
		SignUpPage sp= new SignUpPage(driver);
		sp.setloginEmail(p.getProperty("EmailId"));
		sp.setloginPassward(p.getProperty("passward"));
		sp.clickbtnLogin();
		
		logger.info("**login confirmed**");
		LoginedPage lp=new LoginedPage(driver);
		boolean result=lp.confirmLogin();
		Assert.assertEquals(result, true);
		
				
	}
}
