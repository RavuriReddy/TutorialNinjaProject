package com.tutorialsninja.qa.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Login_btn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement EmailPasswordNotMatchingWarningMessage;
	
	//Actions
	public void EnterUsername(String emailText)
	{
		Username.sendKeys(emailText);
	}
	
	public void EnterPassword(String passwordText)
	{
		Password.sendKeys(passwordText);
	}
	
	public void ClickOnLogin()
	{
		Login_btn.click();
	}
	
	public String ActualWarningMessageOfInvalidCredentials()
	{
		String WarningText=EmailPasswordNotMatchingWarningMessage.getText();
		return WarningText;
	}
	
	public void EnterUsernameUsingTab(String Emailtext)
	{
		Username.sendKeys(Emailtext);
		Username.sendKeys(Keys.TAB);
	}
	
	public void EnterPasswordUsingTab(String Passwordtext)
	{
		Password.sendKeys(Passwordtext);
		Password.sendKeys(Keys.TAB);
	}
}
