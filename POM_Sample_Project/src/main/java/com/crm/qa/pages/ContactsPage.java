package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	
	
	@FindBy(xpath="input[id='first_name']")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement submit;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactPage(){
		return contactlabel.isDisplayed();
	}
	
	public void createNewContact(String title,String firstName, String lastName,String company){
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(lastName);
		driver.findElement(By.name("client_lookup")).sendKeys(company);
		submit.click();
	
	}
	
}
	


