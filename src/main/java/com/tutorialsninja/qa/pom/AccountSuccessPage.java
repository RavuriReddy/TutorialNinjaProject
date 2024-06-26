package com.tutorialsninja.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage
{
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//div[@id='content']//h1") 
	WebElement AccountCreationSuccessMessage;
	
	//Actions
	public String AccountCreationSuccessMessagetext()
	{
		String Displaytext=AccountCreationSuccessMessage.getText();
		return Displaytext;
	}
}
