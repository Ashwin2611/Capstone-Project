package com.unacademy.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	
	public static WebDriver setup(String Browser) {
		switch(Browser) {
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
//		ReportSetup();
		return driver;
		
	}
	
	public static void ReportSetup(String className) {
		if(extent==null) {
			System.out.println("Extent:null");
			createReport(className);
		}
	}
	public static void createReport(String className) {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(className+".html");
		extent.attachReporter(spark);	
	}
	
	public String captureScreenshot(WebDriver driver, String screenshotName) {    
		String path = System.getProperty("C:\\Users\\ashwin.murugan\\eclipse-workspace\\Project") + "/screenshots/" + screenshotName + ".png";   
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);    
		try {        
			FileUtils.copyFile(source, new File(path));    
			} catch (IOException e) {        
				System.out.println("Screenshot capture failed: " + e.getMessage());    
				}    
		return path;}
	
	public static ExtentTest createTest(String MethodName,String Description) {
		return test=extent.createTest(MethodName+"TestCase:"+Description);
	}
	
	public static void FlushReport() {
		extent.flush();
	}
	
	public static void tearDown() {
		driver.quit();
	}

	

}
