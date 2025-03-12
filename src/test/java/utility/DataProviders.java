package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	//Data Provider 1
	@DataProvider(name="TestData1")
	public String[][] getData() throws IOException
	{
		String path=".\\TestData\\TestData1.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalRow=xlutil.getRowCount("sheet1");
		int totalColm=xlutil.getCellCount("Sheet1", 1);
		String logindata[][]=new String [totalRow][totalColm];
		
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalColm;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		return logindata;
	}
}

