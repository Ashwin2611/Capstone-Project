package com.unacademy.testng;

import com.unacademy.Pages.Subscription;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.unacademy.Pages.SearchCourse;
import com.unacademy.Pages.SignOut;
import com.unacademy.Pages.loginPage;
import com.unacademy.base.Base;
import com.unacademy.pageobjects.Unacademy_POM;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

//import Unacademy_POM;
//import com.unacademy.utilities.ReadExcelData;
import com.unacademy.utilities.ReadExcelData;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Unacademy {
	WebDriver driver;
	Properties prob;
	Unacademy_POM pom;
	WebDriverWait wait;
	XSSFSheet sheet;
	String url;
	String email;
	String course;
	ExtentTest test;
  
  
  @Test(dataProvider = "dp",priority=0)
  public void Login(String url, String email,String course) throws Exception {
	  //Login Click
	  driver.get(url);
	  
	  loginPage login=PageFactory.initElements(driver, loginPage.class);
	  
	  pom.clickMethod(login.loginbtn);
	  
	  //Verify
	  login.LoginTitle(test);
	  
	  //Verify
	  login.ContactField(test);
	  
	  //Verify
	  login.Loginbtn(test);
	  
	  login.ContinueWithEmailVerify(test);
	  
	  pom.clickMethod(login.Continuewithemail);
	  
	  //Verify
	  login.EmailField(test);
	  System.out.println("Email:"+email);
	  pom.sendKeysMethod(login.emailField ,email);
	  login.ValidateEmail(email,test);
	  
	  pom.clickMethod(login.Login1);
	  
	  Thread.sleep(3000);
	  
	  //OTP
	  GmailReaderWithOTP readotp=new GmailReaderWithOTP();
      String otp = readotp.fetchOTPFromEmail();
      System.out.println("OTP Retrieved: " + otp);
      
      Thread.sleep(5000);
      
      pom.sendKeysMethod(login.Otp, otp);
//      login.ValidateOTP(otp,test);
     
  }
  
  @Test(dataProvider="dp" ,priority=1)
  public void Search(String url, String email,String course) throws InterruptedException {
	  
	  SearchCourse search=PageFactory.initElements(driver, SearchCourse.class);
	  
	  Thread.sleep(2000);
	  
	  search.SearchField(test);
	  
	  pom.sendKeysMethod(search.searchfield, course);
	  
	  search.ValidateSearchInputCourse(test,course);
	  
	  pom.clickMethod(search.searchbtn);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,400)");
	  
	  WebElement ele = null;
	  try {
	      ele = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div[6]/div/div[1]/div/a"));
	  } catch (NoSuchElementException e) {
	      // Element not found
	  }

	  if (ele != null) {
	      // Element is present
		  
		  //course
	      pom.clickMethod(search.course);
	      
	      search.ValidateInstructorName(test);
	      
	      //Instructor name click
	      pom.clickMethod(search.InstructorName);
	      Thread.sleep(4000);
	      driver.navigate().back();
	      
	      //subscription
	      pom.clickMethod(search.subscriptbtn);
	  } else {
		  //course
	      pom.clickMethod(search.course2);
	      
	      search.ValidateInstructorName(test);
	      
	      //Instructor name click
	      pom.clickMethod(search.InstructorName2);
	      Thread.sleep(4000);
	      driver.navigate().back();
	      
	      //subscription
	      pom.clickMethod(search.subscriptionbtn2);
	  }
	  
	  

  }
  
  @Test(priority=2)
  public void Subscription() throws InterruptedException {
	  
	  Subscription sub=PageFactory.initElements(driver, Subscription.class);
	  
	  sub.PlanVerification(test);
	  pom.clickMethod(sub.Plan);

//	  sub.durationVerification(test);
//	  pom.clickMethod(sub.duration);
	  Thread.sleep(5000);
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("document.querySelector('.wrapper').remove();");
	  
	  sub.proceedtopayVerification(test);
	  pom.clickMethod(sub.proceedtopaybtn);
	  
	  pom.clickMethod(sub.proceedtopay1);
	  
	  sub.paymentVerification(test);
	  pom.clickMethod(sub.paymentMethod);
	  
	  Thread.sleep(3000);
	  
	  driver.navigate().back();
	  
	  pom.clickMethod(sub.HomeLogo2);
  }
  @Test(priority=5)
  public void SignOut() {
	  SignOut signout=PageFactory.initElements(driver, SignOut.class);
	  


	  pom.clickMethod(signout.profile); 
	  
	  signout.SignoutVerify(test);
	  pom.clickMethod(signout.sigoutbtn);
  }
//  
  
  @BeforeMethod
  public void beforeMethod(Method method) throws Exception {
	  test=Base.createTest(method.getName(),"TestCase:"+method.getName());
  }
  
  

  @AfterMethod
  public void afterMethod(ITestResult result,Method method) throws InterruptedException {
//	  Thread.sleep(2000);
		  if(result.getStatus()==ITestResult.FAILURE) {        
			  Base ScreenshotUtil = new Base();        
			  String screenshotPath = ScreenshotUtil.captureScreenshot(driver, method.getName());        
			  String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "Test Failed without specific exception.";        
			  test.log(Status.FAIL, "Test Failed :" + failureMessage+test.addScreenCaptureFromPath(screenshotPath));        
			  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();    
			  }    
		  else if(result.getStatus()==ITestResult.SUCCESS)        
			  test.log(Status.PASS,"The test is passed");    
		  else        
			  test.log(Status.SKIP,"The test is skipped");
  
//	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
	  System.out.println("Sheet: "+sheet);
	ArrayList<Object[]> datalist=new ArrayList<>();
	int noofrows=sheet.getPhysicalNumberOfRows()-1;
//	for(Row row :sheet) {
//		List<String> rowData = new ArrayList<>();
//		for(Cell cell :row) {
//			String name=cell.getStringCellValue();
//			if(name.equals("url")) {
//				break;			
//			}
//			System.out.println(name);
//			rowData.add(name);
//		}
//		datalist.add(new Object[]{rowData});
//	}
	
	for(int i=1;i<noofrows;i++) {
		 url=sheet.getRow(i).getCell(0).getStringCellValue();
		 email=sheet.getRow(i).getCell(1).getStringCellValue();
		 course=sheet.getRow(i).getCell(2).getStringCellValue();
		datalist.add(new Object[] {url,email,course});
	}
	System.out.println("No of rows:"+noofrows);
    return datalist.toArray(new Object[0][]);
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  prob=new Properties();
	  InputStream input=new FileInputStream("C:\\Users\\ashwin.murugan\\eclipse-workspace\\Project\\unadacemy.properties");
	  prob.load(input);
	  String browser=prob.getProperty("Browser");
	  System.out.println(browser);
	  sheet=ReadExcelData.Excel();
	  System.out.println(sheet);
	  driver=Base.setup(browser);
	  String className=getClass().getName();
	  Base.ReportSetup(className);
//	  WebDriverManager.edgedriver().setup();
//	  driver=new EdgeDriver();
	  driver.manage().window().maximize();
	  pom=new Unacademy_POM(driver);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @AfterClass
  public void afterClass() {
	  Base.FlushReport();
//	  Base.tearDown();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
