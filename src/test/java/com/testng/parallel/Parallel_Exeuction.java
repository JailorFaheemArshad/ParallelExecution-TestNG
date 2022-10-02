package com.testng.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel_Exeuction {
WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")

	public void LauchBrowser(String browser)
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			
			
			default:
				driver = null;
			
		}
		
	}
	
	@Test
	public void verifyTitel()
	{
		//open url
		driver.get("http://www.google.com");
		String expectedTitle ="Google";

		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);

	}
	
//	@AfterMethod
//	public void Quit()
//	{
//		driver.quit();
//	}
}
