//WebElement like submit,isDisplayed,implicitlyWait
//Read contact data from Excel
package com.page;



import com.base.BasePage;
import com.utils.PageDriver;

public class Contact extends BasePage{

	public Contact(PageDriver driver) {
		super(driver);
	}
	
	public boolean contactForm(String name,String email,String message,String subject){
		try{
		driver.implicitlyWait();
		driver.findElement("cssSelector-contact").click();
		
		driver.implicitlyWait();
		driver.findElement("xpath-yourname").sendKeys(name);
		driver.findElement("xpath-email").sendKeys(email);
		driver.findElement("xpath-subject").sendKeys(message);
		driver.findElement("cssSelector-message").sendKeys(subject);
		
		driver.findElement("cssSelector-send").submit();
		
		driver.implicitlyWait();
		return driver.findElement("cssSelector-success").isDisplayed();
		}
		
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public void takesScreenshot(){
		driver.screenshot("./Screenshot/Contact.jpg");
	}

}
