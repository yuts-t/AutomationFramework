package com.utils;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class PageDriver {
	private WebDriver driver;
	Configuration config;

	public PageDriver(Configuration config){
		this.config=config;
		start();

	}

	public void start(){
		String browser=config.browser;
		switch(browser)
		{
		case "firefox":
			driver=startFirefox();
			break;
		case "chrome":
			driver=startChrome();
			break;

		case "ie":
			driver=startIE();
			break;
		default:
			driver=startHtml();
			break;
		}
		driver.get(config.url);
	}




	private WebDriver startFirefox(){
		return new FirefoxDriver();
	}
	private WebDriver startChrome(){
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		return new ChromeDriver();
	}
	private WebDriver startIE(){
		System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
	private WebDriver startHtml() {
		return  new HtmlUnitDriver();
	}
	public WebElement findElement(String locator)
	{
		WebElement elem = driver.findElement(Locators.get(locator));
		return elem;
	}


	public List<WebElement> findElements(String locator)
	{
		List<WebElement> list = driver.findElements(Locators.get(locator));

		return list;
	}

	public String SwitchToWindow(){
		return driver.getWindowHandle();
	}

	public Set<String> windowHandles(){

		return driver.getWindowHandles();
	}
	public WebDriver switchTo(String s){

		return driver.switchTo().window(s);
	}
	public String getTitle()
	{
		return driver.getTitle();
	}

	public void implicitlyWait(){
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}



	public void screenshot(String dest){
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile= new File(dest);
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void javascriptExecutor(String s){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(s);
	}
	
	public String titleExecutor(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String s=js.executeScript("return document.title").toString();
		return s;
	}
	
	public void DriverNavigateTo(String s){
		driver.navigate().to(s);
	}
	
	public void ExplicitWait(By locator){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public void close()
	{
		driver.close();
	}
}



