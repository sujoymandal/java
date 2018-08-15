package com.crm.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTest(){
		Assert.assertTrue(homepage.verifyHomePage());
	}
	
	@Test(priority=2)
	public void verifyHomePageTitle(){
		String actual=homepage.verifyHomePageTitle();
		Assert.assertEquals(actual, "CRMPRO");
	}
	
	@Test(priority=3)
	public void verifyContactTest(){
		contactpage=homepage.verifyContact();
		
	}
	

	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
