package com.tutorialsninja.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(id="input-firstname") 
	WebElement FirstNameField;
	
	@FindBy(id="input-lastname") 
	WebElement LastNameField;
	
	@FindBy(id="input-email") 
	WebElement EmailField;
	
	@FindBy(name="telephone") 
	WebElement Telephone;
	
	@FindBy(name="password") 
	WebElement Password;
	
	@FindBy(id="input-confirm") 
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']") 
	WebElement Subscribe;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Continue_btn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement DuplicateWarningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement PrivacyPolicyWarningMessage;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	WebElement FirstNameWarningMessage;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	WebElement LastNameWarningMessage;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	WebElement EmailWarningMessage;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	WebElement TelephoneWarningMessage;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	WebElement PasswordWarningMessage;
	
	
	//Actions
	
	public void EnterFirstName(String firstnametext)
	{
		FirstNameField.sendKeys(firstnametext);
	}
	
	public void EnterLastName(String lastnametext)
	{
		LastNameField.sendKeys(lastnametext);
	}
	
	public void EnterEmail(String Emailtext)
	{
		EmailField.sendKeys(Emailtext);
	}
	
	public void EnterTelephone(String TelephoneNumber)
	{
		Telephone.sendKeys(TelephoneNumber);
	}
	
	public void EnterPassword(String Passwordtext)
	{
		Password.sendKeys(Passwordtext);
	}
	
	public void EnterConfirmPassword(String ConfirmPasswordtext)
	{
		ConfirmPassword.sendKeys(ConfirmPasswordtext);
	}
	
	public void ClickOnSubscribe()
	{
		Subscribe.click();
	}
	
	public void ClickOnPrivacyPolicy()
	{
		PrivacyPolicy.click();
	}
	
	public void ClickOnContinueButton()
	{
		Continue_btn.click();
	}
	
	public String DuplicateWarningMessageText()
	{
		String DisplayText=DuplicateWarningMessage.getText();
		return DisplayText;
	}
	

	public String PrivacyPolicyWarningMessageText()
	{
		String DisplayText=PrivacyPolicyWarningMessage.getText();
		return DisplayText;
	}
	
	public String FirstNameWarningMessageText()
	{
		String DisplayText=FirstNameWarningMessage.getText();
		return DisplayText;
	}
	
	public String LastNameWarningMessageText()
	{
		String DisplayText=LastNameWarningMessage.getText();
		return DisplayText;
	}
	
	public String EmailWarningMessageText()
	{
		String DisplayText=EmailWarningMessage.getText();
		return DisplayText;
	}
	
	public String TelephoneWarningMessageText()
	{
		String DisplayText=TelephoneWarningMessage.getText();
		return DisplayText;
	}
	
	public String PasswordWarningMessageText()
	{
		String DisplayText=PasswordWarningMessage.getText();
		return DisplayText;
	}
	
	
}
