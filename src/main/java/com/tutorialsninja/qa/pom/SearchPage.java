package com.tutorialsninja.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(linkText="HP LP3065") 
	WebElement DisplayedProductName;
	
	@FindBy(xpath="//div[@class='row']//h2//following-sibling::p") 
	WebElement NoProductWarningMessage;
	
	
	//Actions
	public boolean DisplayedProductNameText()
	{
		boolean DisplayedText=DisplayedProductName.isDisplayed();
		return DisplayedText;
	}
	
	public String NoProductWarningMessageText()
	{
		String DisplayedText=NoProductWarningMessage.getText();
		return DisplayedText;
	}
}
