package com.page;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.base.BasePage;
import com.utils.Configuration;
import com.utils.Locators;
import com.utils.PageDriver;


public class HomePage extends BasePage {



	public HomePage(PageDriver driver) {
		super(driver);
	}

	public boolean isLogoAvailable(){
		boolean isPresent=false;

		WebElement element=driver.findElement("xpath-logo");
		if(element!=null){
			isPresent=true;
		}
		return isPresent;
	}



	public boolean facebookButton(){

		boolean isPresent=false;

		WebElement element=driver.findElement("cssSelector-facebookButton");
		if(element!=null){
			isPresent=true;
		}


		return isPresent;
	}

	public boolean twitterButton(){

		boolean isPresent=false;
		WebElement element=driver.findElement("cssSelector-twitterButton");
		if(element!=null){
			isPresent=true;
		}


		return isPresent;
	}
	
	public boolean googleButton(){

		boolean isPresent=false;

		WebElement element=driver.findElement("cssSelector-googleButton");
		isPresent=element.isDisplayed();
		return isPresent;
	}

	public Point sideBarLocation(){

		Point element=driver.findElement("cssSelector-sidebar").getLocation();
		return element;
	}

	public Dimension imageSize(){

		Dimension size=driver.findElement("cssSelector-homepageImage").getSize();
		return size;
	}

	public String title(){
		String s=driver.titleExecutor();
		return s;
	}
	public boolean navBar(){
		boolean isNumNavBar=false;
		
		List listElement=driver.findElements("xpath-navbar");
		if(listElement.size()==6){
			isNumNavBar=true;
			
		}
		
		return isNumNavBar;
	}
	
	
	public void takesScreenshot(){
		driver.screenshot("./Screenshot/HomePageScreenshot.jpg");
	}
	


}


