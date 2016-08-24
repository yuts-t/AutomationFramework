package com.test;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BasePageTest;
import com.page.FramesAndWindows;

public class FramesAndWindowsTest extends BasePageTest {
	
	FramesAndWindows fw;
	
	@BeforeClass
	public void createObj(){
		fw=new FramesAndWindows(driver);
	}
	
	@Test
	public void test(){
		assertTrue(fw.WindowHandle());
	}
	
	@Test
	public void screenshot(){
		fw.takesScreenshot();
	}
	
	@AfterClass
	public void close(){
		driver.close();
	}
	

}
