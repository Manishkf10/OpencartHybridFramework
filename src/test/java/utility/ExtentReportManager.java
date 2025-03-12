package utility;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseTest;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;

	public void onTestStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy:mm:dd:hh:mm:ss").format(new Date());// to make time visible
		repName="Test-Report-"+timeStamp+".html";// use time to create new file name each time
		System.out.println("1");
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//giving location where we want to generate reports
	    
		sparkReporter.config().setDocumentTitle("opencart Hybird Test");// title of report
		sparkReporter.config().setReportName("opencart Functional Testing");//name of report
		sparkReporter.config().setTheme(Theme.DARK);
		System.out.println("2");
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("sub Module", "customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviroment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operation system", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to display groups in reports
		test.log(Status.PASS, result.getName()+"got successfully execute");
		   
	}

	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to display groups in reports
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			String imgPath=new BaseTest().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to display groups in reports
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinsh(ITestResult result)
	{
		extent.flush();
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\repName";
		File extentReport= new File(pathOfExtentReport);
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
		
		
		
		
	
		
		

	

}
