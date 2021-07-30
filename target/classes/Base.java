package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	  public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C://Swathi//Java_Eclipse//workspace-1.1//E2EProjectCollective//src//main//java//resources//data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);


//Select browser from data.properties
if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C://Swathi//Browser drivers//chromedriver_win32 (4)//chromedriver.exe");
	driver= new ChromeDriver();
	
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver", "C://Swathi//Browser drivers//chromedriver_win32 (4)//geckodriver.exe");
	 driver= new FirefoxDriver();
	
}

//Implicit wait
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

return driver;
}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Swathi\\Java_Eclipse\\Screenshot"+result+"screenshot.png"));
	
}

}
