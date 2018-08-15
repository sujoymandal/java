package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory --Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id='navbar-collapse']/ul/li[2]/a")
	WebElement signup;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String LoginTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	public SignupPage signupButton(){
		signup.click();
		return new SignupPage();
	}
	

}
