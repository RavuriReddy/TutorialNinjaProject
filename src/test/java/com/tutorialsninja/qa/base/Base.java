package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base
{
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base()
	{
		prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		dataprop=new Properties();
		File datapropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try
		{
		FileInputStream datafis=new FileInputStream(datapropfile);
		dataprop.load(datafis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
		FileInputStream fis=new FileInputStream(propfile);
		prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	
	public WebDriver IntializeTheBrowserAndOpenApplication(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.Page_Load_Time));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
