package com.unacademy.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.unacademy.Pages.AboutPage;
import com.unacademy.Pages.SelectCourse;
import com.unacademy.Pages.SignOut;
import com.unacademy.Pages.Subscription;
import com.unacademy.Pages.loginPage;
import com.unacademy.base.Base;
import com.unacademy.pageobjects.Unacademy_POM;
import com.unacademy.utilities.ReadExcelData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class unacademyFlow3 {
	WebDriver driver;
	Properties prob;
	Unacademy_POM pom;
	WebDriverWait wait;
	XSSFSheet sheet;
	ExtentTest test;
	 @Test(dataProvider = "dp",priority=0)
	  public void Login(String url, String email,String instructor) throws Exception {
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
//	      login.ValidateOTP(otp,test);
	     
	  }
	 
	 @Test(priority=1)
	 public void SelectedCourse() throws InterruptedException {
		  
		 SelectCourse course=PageFactory.initElements(driver, SelectCourse.class);
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,300)");
		 Thread.sleep(3000);
		 course.Course(test);
		 pom.clickMethod(course.coursesection);
		 
		 course.CourseModule(test);
		 pom.clickMethod(course.coursemodule);
		 Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0,200)");
		 Thread.sleep(2000);
		 course.Subscriptbtn(test);
		 pom.clickMethod(course.subscriptbtn);
		 
	 }
	 
	 @Test(priority=2)
	 public void Subscription() throws InterruptedException {
		 Subscription sub=PageFactory.initElements(driver, Subscription.class);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 sub.PlanVerification(test);
		 pom.clickMethod(sub.Plan);
		 
		 js.executeScript("window.scrollBy(0,150)");
		 
		 Thread.sleep(1000);
		 
		 sub.durationVerification(test);
		 pom.clickMethod(sub.duration);
		 
		 Thread.sleep(2000);
		 
		 sub.proceedtopayVerification(test);
		 pom.clickMethod(sub.proceedtopaybtn);
		 
		 pom.clickMethod(sub.proceedtopay1);
		 
		 sub.paymentVerification(test);
		 pom.clickMethod(sub.paymentMethod);
		  
		 Thread.sleep(3000);
		  
		 driver.navigate().back();
		  
		 Thread.sleep(2000);
		 
		 pom.clickMethod(sub.HomeLogo2);
	 }
	 
	 @Test(priority=3)
	 public void AboutCompany() throws InterruptedException {
		 
		 AboutPage about=PageFactory.initElements(driver, AboutPage.class);
		 
		 pom.clickMethod(about.AboutExam);
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,200)");
		 
		 about.AboutPages(test);
		 
		 pom.clickMethod(about.AboutPage);
		 
		 WindowHandler handle=new WindowHandler(driver);

		 handle.WindowHandle(1);
		 
		 about.Career(test);
		 
		 pom.clickMethod(about.CareersPage);
		 
		 handle.WindowHandle(2);
		 
		 about.Privacypolicy(test);
		 
		 pom.clickMethod(about.PrivacyPolicyPage);
		 
		 handle.WindowHandle(3);
		 
		 
	 }
	 
	 @Test(priority=4)
	 public void ReachOutToUs() throws InterruptedException {
		 AboutPage about=PageFactory.initElements(driver, AboutPage.class);
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,250)");
		 
		 about.Reactouttitle(test);
		 
//		 pom.clickMethod(about.ReactOutContact);
		 
		 about.ReactoutContacts(test);
//		 Alert alt=driver.switchTo().alert();
//		 Thread.sleep(2000);
//		 alt.accept();
	 }
	 
	  
	  @Test(priority=5)
	  public void SignOut() {
		  SignOut signout=PageFactory.initElements(driver, SignOut.class);
		  
		  signout.profileVerify(test);
		  pom.clickMethod(signout.profile); 
		  
		  signout.SignoutVerify(test);
		  pom.clickMethod(signout.sigoutbtn);
	  }
	 
	 
  @BeforeMethod
  public void beforeMethod(Method method) {
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
//		for(Row row :sheet) {
//			List<String> rowData = new ArrayList<>();
//			for(Cell cell :row) {
//				String name=cell.getStringCellValue();
//				if(name.equals("url")) {
//					break;			
//				}
//				System.out.println(name);
//				rowData.add(name);
//			}
//			datalist.add(new Object[]{rowData});
//		}
		
		for(int i=1;i<noofrows;i++) {
			String url=sheet.getRow(i).getCell(0).getStringCellValue();
			String email=sheet.getRow(i).getCell(1).getStringCellValue();
			String instructor=sheet.getRow(i).getCell(3).getStringCellValue();
			datalist.add(new Object[] {url,email,instructor});
			
		}
		System.out.println("Noofrows"+noofrows);
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
