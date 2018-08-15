package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
		contactspage=new ContactsPage();
		
	}
	
	@Test(priority=1)
	public void verifyContactPageTest(){
		homepage.verifyContact();
		Assert.assertTrue(contactspage.verifyContactPage());
	}
	
	@DataProvider
	public Object[][] getCRMtestData() throws Exception{
		Object[][] data=TestBase.getTestData(prop.getProperty("testdata"), prop.getProperty("contacts_sheet"));
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMtestData")
	public void newContactEntryTest(String Title,String First_Name,String Last_Name,String Company)  {
		homepage.newContactEntry();
		contactspage.createNewContact(Title,First_Name, Last_Name,Company);
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
