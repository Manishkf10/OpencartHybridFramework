package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignUpDetailsPage;
import pageObjects.SignUpPage;

public class TC001_AcountRegistration extends BaseTest {
	
	
	 
	@Test(groups= {"Sanity", "Master"})
	public void registration()
	{
		
		
		logger.info("****Starting TC001_AcountRegistration***");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickSignUP();
		
		SignUpPage sp= new SignUpPage(driver);
		sp.setName("Manish");
		

		String ran=RandomStringUtils.randomAlphabetic(5);
		sp.setEmail(ran+"@gmail.com");
		
		sp.clickbtnSigUp();
		logger.info("****clicking signUp***");
		SignUpDetailsPage reg=new SignUpDetailsPage(driver);
		logger.info("****Providing SignUpDetails***");
		reg.setTitle();
		reg.setPassword("hello123");
		reg.setfirstName("Manish");
		reg.setlastName("kumar");
		reg.setcompany("micro");
		reg.setaddress("Dehradun");
		reg.setmobileNumber("1234567890");
		reg.setDayDOB("18");
		reg.setMnthDOM("October");
		reg.setyearDOB("1994");
		reg.scetstate("Utrrakhand");
		reg.setcity("Dehradun"); 
		reg.setzipcode("201102");
		logger.info("****clicking creating account***");
		reg.btnCreatAc();
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			
		}
		
		
	}

}
