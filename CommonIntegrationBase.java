package week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CommonIntegrationBase 
{
	public String fileName;
	public RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
@BeforeMethod
	public void preCondition(String brow,String url,String uName,String pName)
	{
		if(brow.equalsIgnoreCase("chrome"))
		{
	driver= new ChromeDriver();
		}
		else if(brow.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys(uName);
	driver.findElement(By.id("password")).sendKeys(pName);
	System.out.println("precondition executed");
	}
@AfterMethod
	public void postCondition()
	{
	driver.close();
	System.out.println("postcondition executed");
	}

@DataProvider(name="fetchData")
public String[][] sendData() throws IOException
{
	String[][] excelRead = Xcel_CommonIntegration.excelRead(fileName);		
	return excelRead;
}
}
