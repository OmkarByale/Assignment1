package com.asign1.generics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



abstract public class BaseTest implements IAutoConstant {
	
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	
	public WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
