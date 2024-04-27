package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pom.HomePage;
import com.tutorialsninja.qa.pom.SearchPage;

public class SearchTest extends Base
{
	public WebDriver driver;
	
	public SearchTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=IntializeTheBrowserAndOpenApplication(prop.getProperty("browserName"));
	}
	
	@Test(priority=1)
	public void VerifySearchWithExistingProduct()
	{
		HomePage homepage=new HomePage(driver);
		homepage.EnterSearchBox(dataprop.getProperty("ValidProductName"));
		homepage.ClickOnSearch();
		
		SearchPage searchpage=new SearchPage(driver);
		
		boolean ActualProductName=searchpage.DisplayedProductNameText();
		Assert.assertTrue(ActualProductName,"valid product hp is not displayed");
		
	}
	
	@Test(priority=2)
	public void VerifySearchWithNonExistingProduct()
	{
		HomePage homepage=new HomePage(driver);
		homepage.EnterSearchBox(dataprop.getProperty("InvalidProductName"));
		homepage.ClickOnSearch();
		
		SearchPage searchpage=new SearchPage(driver);
		String ActualWarningMessage=searchpage.NoProductWarningMessageText();
		Assert.assertEquals(ActualWarningMessage,dataprop.getProperty("NoProductWarningMessage") ,"No product warning message is not displayed");
	}
	
	@Test(priority=3)
	public void VerifySearchWithoutEnteringProductName()
	{	
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnSearch();
		
		SearchPage searchpage=new SearchPage(driver);
		
		String ActualWarningMessage=searchpage.NoProductWarningMessageText();
		Assert.assertEquals(ActualWarningMessage, dataprop.getProperty("NoProductWarningMessage"),"No product warning message is not displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
