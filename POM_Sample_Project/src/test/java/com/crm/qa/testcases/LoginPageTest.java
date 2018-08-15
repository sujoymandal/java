package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SignupPage signuppage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
	}
	
	
	
	@Test(priority=1)
	public void titleTest(){
		String actual=loginpage.LoginTitle();
		Assert.assertEquals(actual, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void loginTest(){
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=3)
	public void signupButtonTest(){
		signuppage=loginpage.signupButton();
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
