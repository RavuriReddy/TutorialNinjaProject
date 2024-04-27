package com.tutorialsninja.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage
{
WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(linkText="Edit your account information")
	WebElement EditYourAccountPageInformation;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccountPageInformation;
	
	//Actions
	public boolean DisplayAccountInformation()
	{
		boolean displayStatus=EditYourAccountPageInformation.isDisplayed();
		return displayStatus;
		//AccountPageInformation.isDisplayed();
	}
	
	public String DisplayMyAccountPageInformation()
	{
		String informationStatus=MyAccountPageInformation.getText();
		return informationStatus;
		//AccountPageInformation.isDisplayed();
	}
	
}
