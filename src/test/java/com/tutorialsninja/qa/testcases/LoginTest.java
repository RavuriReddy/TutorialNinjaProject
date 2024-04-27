package com.tutorialsninja.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pom.AccountPage;
import com.tutorialsninja.qa.pom.HomePage;
import com.tutorialsninja.qa.pom.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

//import utilities.ExcelUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class LoginTest extends Base
{
	public WebDriver driver;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=IntializeTheBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage home=new HomePage(driver);
		home.ClickOnMyAccount();
		home.ClickOnLogin();
	}
	
	
	@Test(priority=1,dataProvider="LoginData")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(email);
		login.EnterPassword(password);
		login.ClickOnLogin();
		
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.DisplayAccountInformation(), "Edit your account information is not displayed");
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\Login_Test_Data.xlsx";//taking xl file from testData
		
		Utilities xlutil=new Utilities(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	{
		
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(Utilities.generateEmailWithTimeStamp());
		login.EnterPassword(dataprop.getProperty("InvalidPassword"));
		login.ClickOnLogin();
		
		String actualWarningMessage=login.ActualWarningMessageOfInvalidCredentials();
		String ExpectedWarningMessage=dataprop.getProperty("EmailPasswordNotMatching");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Expected warning message is not displayed");
	
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(Utilities.generateEmailWithTimeStamp());
		login.EnterPassword(prop.getProperty("validPassword"));
		login.ClickOnLogin();
		
		String actualWarningMessage=login.ActualWarningMessageOfInvalidCredentials();
		String ExpectedWarningMessage=dataprop.getProperty("EmailPasswordNotMatching");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(prop.getProperty("validEmail"));
		login.EnterPassword(dataprop.getProperty("InvalidPassword"));
		login.ClickOnLogin();
			
		String actualWarningMessage=login.ActualWarningMessageOfInvalidCredentials();
		String ExpectedWarningMessage=dataprop.getProperty("EmailPasswordNotMatching");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials()
	{
		LoginPage login=new LoginPage(driver);
		login.ClickOnLogin();
		
		String actualWarningMessage=login.ActualWarningMessageOfInvalidCredentials();
		String ExpectedWarningMessage=dataprop.getProperty("EmailPasswordNotMatching");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Expected warning message is not displayed");
		
	}
	
	@Test(priority=6)
	public void verifyLoginUsingTabAndEnter()
	{
		
		LoginPage login=new LoginPage(driver);
		login.EnterUsernameUsingTab(prop.getProperty("validEmail"));
		login.EnterPasswordUsingTab(prop.getProperty("validPassword"));
		login.ClickOnLogin();
	
		//login_btn.sendKeys(Keys.ENTER);
		
		AccountPage accountpage=new AccountPage(driver);
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		String actualtext=accountpage.DisplayMyAccountPageInformation();
		String Expectedtext="My Account";
		Assert.assertTrue(actualtext.contains(Expectedtext),"Expected text is not displayed");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
