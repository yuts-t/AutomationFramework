package com.page;



import java.util.Iterator;
import java.util.Set;



import com.base.BasePage;

import com.utils.PageDriver;



public class FramesAndWindows extends BasePage {

	public FramesAndWindows(PageDriver driver) {
		super(driver);
	}

	public boolean WindowHandle(){
		try{
			//driver.findElement("xpath-frameMenu");
			
			driver.DriverNavigateTo("http://demoqa.com/frames-and-windows/");
			
			driver.findElement("xpath-separate").click();
			driver.findElement("xpath-tab").click();
			String parentWindow=driver.SwitchToWindow();;
			System.out.println("Before Switching: " +driver.getTitle());
			Set<String> s1=driver.windowHandles();
			Iterator<String> i=s1.iterator();
			while(i.hasNext()){

				String childWindow=i.next();
				if(!parentWindow.equalsIgnoreCase(childWindow)){
					driver.switchTo(childWindow);

					System.out.println("After switching: "+driver.getTitle());
					driver.close();
				}

			}
			driver.switchTo(parentWindow);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void takesScreenshot(){
		driver.screenshot("./Screenshot/FramesAndWindows.jpg");
	}

}
