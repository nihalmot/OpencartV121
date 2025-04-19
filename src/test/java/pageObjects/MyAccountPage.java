package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//MyAcccountPage constructor
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	//locators of MyAccountPage
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")    //My Account heading
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")    //Logout link
	WebElement lnkLogout;
	
	//Action methods
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
