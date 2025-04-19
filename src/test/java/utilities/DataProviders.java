package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";  //taking excel file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);  //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata [][] = new String[totalrows][totalcols];  //created for 2D array which can store excel data in the array
		
		for(int i=1;i<=totalrows;i++)  //1  //reads the data from excel storing in 2D array
		{
			for(int j=0;j<totalcols;j++)  //0  i is row j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;  //returning 2D array
	}
	
	
	
	
	
}
