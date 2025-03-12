package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginedPage;
import pageObjects.SignUpPage;
import utility.DataProviders;


public class TC003LoginTestWithDDT extends BaseTest{
	
	@Test(dataProvider="TestData1",dataProviderClass=DataProviders.class,groups= {"DataDriven","Master"})// getting dataprovider from diff. Class
	public void VerfyLogin(String email, String pswd, String validation)
	{
		System.out.println(email);
		logger.info("**sTARTING LOGIN DDT TEST**");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickSignUP();
		logger.info("**login page**");
		SignUpPage sp= new SignUpPage(driver);
		sp.setloginEmail(email);
		sp.setloginPassward(pswd);
		sp.clickbtnLogin();
		
		logger.info("**login confirmed**");
		LoginedPage lp=new LoginedPage(driver);
		boolean result=lp.confirmLogin();
		
		/*
		data is valid=login successful = test passed
		data is valid=login failed= test failed
		data is invalid= login failed= test passsed
		data is invalid=login successful= test failed

	*/
		
		if(validation.equalsIgnoreCase("valid"))
		{
			if(result==true)
			{
				lp.clickbtnLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			  
		}
		else if(validation.equalsIgnoreCase("Invalid"))
		{
			if(result==true)
			{
				lp.clickbtnLogOut();
				Assert.assertTrue(false);		
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}

	
		}
		
}

