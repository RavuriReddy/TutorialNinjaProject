package com.tutorialsninja.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement MyAccountDropDown;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Loginlink;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement Registerlink;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button")
	private WebElement Search_Btn;
	
	
	//Actions
	public void ClickOnMyAccount()
	{
		MyAccountDropDown.click();
	}
	
	public void ClickOnLogin()
	{
		Loginlink.click();
	}
	
	public void ClickOnRegister()
	{
		Registerlink.click();
	}
	
	public void EnterSearchBox(String SearchText)
	{
		SearchBox.sendKeys(SearchText);
	}
	
	public void ClickOnSearch()
	{
		Search_Btn.click();
	}
}
