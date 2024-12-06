package com.unacademy.testng;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WindowHandler {
	WebDriver driver;
	
	public WindowHandler(WebDriver driver) {
		this.driver=driver;
	}
	public void WindowHandle(int site) throws InterruptedException {
		ArrayList<String> list=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(list.get(site));
		System.out.println(driver.getCurrentUrl());
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		for(String i:list) {
			System.out.println(i);
		}
		for(int i=0;i<6;i++) {
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(500);
		}
		Thread.sleep(5000);
		driver.switchTo().window(list.get(0));	
	}

}
