package com.test;



import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BasePageTest;
import com.page.Registration;

public class RegistrationTest extends BasePageTest{
	
	Registration reg;
	@BeforeSuite
	public void objCreate(){
		reg=new Registration(driver);
	}
	
	@Test
	public void existingUserRegistrationTest(){
		String expected="Error: Username already exists";
		String actual=reg.existingUserRegistration();
		Assert.assertEquals(actual, expected);
		}
	
	@Test
	public void nonExistingUserRegistrationTest(){
		String expected="Thank you for your registration";
		String actual=reg.nonExistingUserRegistration();
		Assert.assertEquals(actual, expected);
	}
	
	
	
	
	
	
	
	

}
