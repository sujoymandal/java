package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	//Page Factory
	@FindBy(xpath="//td//td[contains(*,'User: Naveen K')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyHomePage(){
		TestBase.switchToframe();
		return usernamelabel.isDisplayed();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage verifyContact(){
		TestBase.switchToframe();
		contacts.click();
		return new ContactsPage();
	}
	
public void newContactEntry(){
		TestBase.switchToframe();
	    Actions action=new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
}

}
