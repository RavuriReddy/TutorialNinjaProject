package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pom.AccountSuccessPage;
import com.tutorialsninja.qa.pom.HomePage;
import com.tutorialsninja.qa.pom.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base
{
	public WebDriver driver;

	public RegisterTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=IntializeTheBrowserAndOpenApplication(prop.getProperty("browserName"));
		
		HomePage home=new HomePage(driver);
		home.ClickOnMyAccount();
		home.ClickOnRegister();
		
		/*WebElement myaccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
		myaccount.click();
		
		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		register.click();*/
		
		//WebElement login = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
		//login.click();
	}
	
	@Test(priority=1)
	public void VerifyRegisteringAnAccountWithMandetoryFields()
	{
		RegisterPage register=new RegisterPage(driver);
		register.EnterFirstName(dataprop.getProperty("Firstname"));
		register.EnterLastName(dataprop.getProperty("Lastname"));
		register.EnterEmail(Utilities.generateEmailWithTimeStamp());
		register.EnterTelephone(dataprop.getProperty("Telephone"));
		register.EnterPassword(prop.getProperty("validPassword"));
		register.EnterConfirmPassword(prop.getProperty("validPassword"));
		register.ClickOnPrivacyPolicy();
		register.ClickOnContinueButton();
		
		AccountSuccessPage accountsuccess=new AccountSuccessPage(driver);
		String ConfirmMessage=accountsuccess.AccountCreationSuccessMessagetext();
		Assert.assertEquals(ConfirmMessage, dataprop.getProperty("AccountSuccessfullyCreatedMessage"),"Account is not created");
	}
	
	@Test(priority=2)
	public void VerifyRegisteringAccountByEnteringAllFields()
	{
		RegisterPage register=new RegisterPage(driver);
		register.EnterFirstName(dataprop.getProperty("Firstname"));
		register.EnterLastName(dataprop.getProperty("Lastname"));
		register.EnterEmail(Utilities.generateEmailWithTimeStamp());
		register.EnterTelephone(dataprop.getProperty("Telephone"));
		register.EnterPassword(prop.getProperty("validPassword"));
		register.EnterConfirmPassword(prop.getProperty("validPassword"));
		register.ClickOnSubscribe();
		register.ClickOnPrivacyPolicy();
		register.ClickOnContinueButton();
		
		AccountSuccessPage accountsuccess=new AccountSuccessPage(driver);
		
		String ConfirmMessage=accountsuccess.AccountCreationSuccessMessagetext();
		Assert.assertEquals(ConfirmMessage, dataprop.getProperty("AccountSuccessfullyCreatedMessage"),"Account is not created");
	}
	
	@Test(priority=3)
	public void VerifyRegisteringAccountByProvidingExistingDetails()
	{
		RegisterPage register=new RegisterPage(driver);
		register.EnterFirstName(dataprop.getProperty("Firstname"));
		register.EnterLastName(dataprop.getProperty("Lastname"));
		register.EnterEmail(prop.getProperty("validEmail"));
		register.EnterTelephone(dataprop.getProperty("Telephone"));
		register.EnterPassword(prop.getProperty("validPassword"));
		register.EnterConfirmPassword(prop.getProperty("validPassword"));
		register.ClickOnSubscribe();
		register.ClickOnPrivacyPolicy();
		register.ClickOnContinueButton();
		
		String WarningMessage=register.DuplicateWarningMessageText();
		//String WarningMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(WarningMessage, dataprop.getProperty("DuplicatingWarningMessage"),"Warning message is not displayed");
	}
	
	@Test(priority=4)
	public void VerifyRegisteringAccountWithOutFillingAnyDetails()
	{
		RegisterPage register=new RegisterPage(driver);
		register.ClickOnContinueButton();
		
		String ActualPrivacyPolicyWarningMessage=register.PrivacyPolicyWarningMessageText();
		Assert.assertEquals(ActualPrivacyPolicyWarningMessage,dataprop.getProperty("PrivacyPolicyWarningMessage") ,"Privacy Policy Warning message is not displayed");
		
		String ActualFirstNameWarningMessage=register.FirstNameWarningMessageText();
		Assert.assertEquals(ActualFirstNameWarningMessage, dataprop.getProperty("FirstNameWarningMessage"),"First Name Warning message is not displayed");
		
		String ActualLastNameWarningMessage=register.LastNameWarningMessageText();
		Assert.assertEquals(ActualLastNameWarningMessage, dataprop.getProperty("LastNameWarningMessage"),"Last Name Warning message is not displayed");
		
		String ActualEmailWarningMessage=register.EmailWarningMessageText();
		Assert.assertEquals(ActualEmailWarningMessage, dataprop.getProperty("EmailWarningMessage"),"Email Warning message is not displayed");
		
		String ActualTelephoneWarningMessage=register.TelephoneWarningMessageText();
		Assert.assertEquals(ActualTelephoneWarningMessage, dataprop.getProperty("TelephoneWarningMessage"),"Telephone Warning message is not displayed");
		
		String ActualPasswordWarningMessage=register.PasswordWarningMessageText();
		Assert.assertEquals(ActualPasswordWarningMessage, dataprop.getProperty("PasswordWarningMessage"),"Password Warning message is not displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
