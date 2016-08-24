//JavascriptExecutor
package com.page;

import java.io.IOException;
import java.util.UUID;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;
import com.utils.PageDriver;

public class Registration extends BasePage{


	public Registration(PageDriver driver)
	{
		super(driver);
	}
	public String existingUserRegistration(){


		driver.findElement("cssSelector-registrationLink").click();

		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//------Registration Form-------

		//textbox
		driver.findElement("cssSelector-firstname").sendKeys("test");
		driver.findElement("cssSelector-lastname").sendKeys("test");

		//radio button

		driver.findElement("xpath-maritalStatus").click();

		//checkbox

		driver.findElement("xpath-hobby").click();

		//dropdown(using id Locator)
		Select country  = new Select(driver.findElement("id-country"));
		country.selectByVisibleText("India");

		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//dropdown month with selectByValue (using cssSelector locator)
		Select month=new Select(driver.findElement("cssSelector-month"));
		month.selectByValue("12");

		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//dropdown day with selectByIndex(using name locator)
		Select day=new Select(driver.findElement("name-day"));
		day.selectByIndex(20);

		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//dropdown year 
		Select year=new Select(driver.findElement("cssSelector-year"));
		year.selectByValue("1996");

		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//textbox phoneNumber
		driver.findElement("cssSelector-phone").sendKeys("0123456789");

		//textbox userName
		driver.findElement("cssSelector-username").sendKeys("test");

		//textbox Email
		driver.findElement("cssSelector-email").sendKeys("test@test.com");



		//file upload using AutoIt
		driver.findElement("cssSelector-profilePic").click();
		try {
			Runtime.getRuntime().exec("C:/Users/kabi/Desktop/upload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//textbox about yourself
		driver.findElement("cssSelector-description").sendKeys("I am test.");

		//textbox password
		driver.findElement("cssSelector-password").sendKeys("example123");

		//textbox confirm password
		driver.findElement("cssSelector-confirmPassword").sendKeys("example123");

		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.findElement("xpath-submit").click();

		String actualText=driver.findElement("xpath-successRegistered").getText();

		return actualText;
	}
	public String nonExistingUserRegistration(){
		driver.findElement("cssSelector-registrationLink").click();



		//------Registration Form-------

		//textbox
		driver.findElement("cssSelector-firstname").sendKeys("exampleTestexample");
		driver.findElement("cssSelector-lastname").sendKeys("exampleTest");

		//radio button

		driver.findElement("xpath-maritalStatus").click();

		//checkbox

		driver.findElement("xpath-hobby").click();

		//dropdown(using id Locator)
		Select country  = new Select(driver.findElement("id-country"));
		country.selectByVisibleText("United States");

		//dropdown month with selectByValue (using cssSelector locator)
		Select month=new Select(driver.findElement("cssSelector-month"));
		month.selectByValue("12");

		//dropdown day with selectByIndex(using name locator)
		Select day=new Select(driver.findElement("name-day"));
		day.selectByIndex(20);

		//dropdown year 
		Select year=new Select(driver.findElement("cssSelector-year"));
		year.selectByValue("1996");

		//textbox phoneNumber
		driver.findElement("cssSelector-phone").sendKeys("0123456789");

		//textbox userName
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		driver.findElement("cssSelector-username").sendKeys("exampleTest_" +randomUUIDString);

		//textbox Email
		UUID uuidEmail = UUID.randomUUID();
        String randomUUIDStringEmail = uuidEmail.toString();
		driver.findElement("cssSelector-email").sendKeys("test_" +randomUUIDStringEmail+"@test.com");



		//file upload using AutoIt
		driver.findElement("cssSelector-profilePic").click();
		try {
			Runtime.getRuntime().exec("C:/Users/kabi/Desktop/upload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//textbox about yourself
		driver.findElement("cssSelector-description").sendKeys("I am test.");

		//textbox password
		driver.findElement("cssSelector-password").sendKeys("example123");

		//textbox confirm password
		driver.findElement("cssSelector-confirmPassword").sendKeys("example123");

		driver.findElement("xpath-submit").click();

		String actualText=driver.findElement("xpath-successRegistered").getText();
		driver.screenshot("./Screenshot/RegistrationScreenshot.jpg");

		return actualText;
	}
	
	
	
	
}
