package com.test;
import static org.testng.Assert.*;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BasePageTest;
import com.page.HomePage;

public class HomePageTest extends BasePageTest {
	HomePage hp;

	@BeforeClass
	public void objCreate()
	{
		hp = new HomePage(driver);
	}

	@Test
	public void isLogoAvailableTest(){
		assertTrue(hp.isLogoAvailable());
	}

	@Test
	public void facebookButtonTest(){
		assertTrue(hp.facebookButton());
	}
	
	@Test
	public void  twitterButtonTest(){
		assertTrue(hp.twitterButton());
	}
	
	@Test
	public void  googleButtonTest(){
		assertTrue(hp.googleButton());
	}

	@Test
	public void navBarTest(){
		assertTrue(hp.navBar());
	}
	
	@Test
	public void titleHomepage(){
		System.out.println("Title of HomePage:" +hp.title());
	}
	
	@Test
	public void testScreenshot(){
		hp.takesScreenshot();
	}


}
