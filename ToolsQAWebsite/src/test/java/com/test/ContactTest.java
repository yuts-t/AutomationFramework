package com.test;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BasePageTest;
import com.page.Contact;

public class ContactTest extends BasePageTest {
	
	Contact con;
	
	@BeforeClass
	public void createObj(){
		con=new Contact(driver);
	}
	
	
	@DataProvider(name="contact-data")
	public Object[][] getUsers()
	{
		Object[][] data = excelData.getData();
		return data;
	}
	
	@Test(dataProvider="contact-data")
	public void contactForm(String name,String email,String message,String subject)
	{
		boolean isContactSuccess = con.contactForm(name, email, message, subject);
		assertTrue(isContactSuccess);
	}
	
	@Test
	public void screenshot(){
		con.takesScreenshot();
	}
	
	
	
	

}
