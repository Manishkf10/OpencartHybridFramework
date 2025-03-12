package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest 
{
	
public static WebDriver driver;
public Logger logger;
public Properties p;	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	public void setup() throws IOException
	{
		//loading properties file
		FileReader f= new FileReader("./src//test//resources//commonData.properties");
		p=new Properties();
		p.load(f);
		
		logger=LogManager.getLogger(this.getClass());
		driver= new ChromeDriver();
		driver.get(p.getProperty("URL1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
		
	}
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyy:mm:dd:hh:mm:ss").format(new Date());
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		File sourcefile=takeScreenShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty(".\\screenshots\\"+tname+"_"+timeStamp);
		File targetFile= new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		return targetFilePath;
	}
	
	

}
