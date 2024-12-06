package com.unacademy.testng;

import org.testng.annotations.Test;

import com.unacademy.Pages.SignOut;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.unacademy.Pages.AddGoal;
import com.unacademy.Pages.RemoveCourse;
import com.unacademy.Pages.SearchCourse;
import com.unacademy.Pages.Subscription;
import com.unacademy.Pages.loginPage;
import com.unacademy.base.Base;
import com.unacademy.pageobjects.Unacademy_POM;
import com.unacademy.utilities.ReadExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class unacademyFlow2 {
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
      login.ValidateOTP(otp,test);
     
  }
  
  @Test(priority=1)
  public void AddGoal() throws InterruptedException {
      
	  AddGoal goal=PageFactory.initElements(driver,AddGoal.class);
      //Add Goal
      pom.clickMethod(goal.addGoalbtn);
      
      goal.VerifyTitle(test);
      
      goal.VerifyAddGoalbtn(test);
      
      
      pom.clickMethod(goal.addGoalbtn2);
      
      
      Thread.sleep(3000);
      JavascriptExecutor js=(JavascriptExecutor)driver;
      js.executeScript("window.scrollBy(0,300)");
      Thread.sleep(3000);
      
      //select exam
      pom.clickMethod(goal.selectExam);
      
      //language
      pom.clickMethod(goal.Language);
      
      goal.GiftIconVerify(test);
      
      //gift icon
      pom.clickMethod(goal.giftIcon);
      
      //referral code title
      goal.VerifyReferralCode(test);
      
      //copy referral
      pom.clickMethod(goal.referralCode);
      
      //home logo
      pom.clickMethod(goal.HomeLogo);
  }
  
  @Test(dataProvider="dp" ,priority=2)
  public void Search(String url, String email,String instructor) throws InterruptedException {
	  
	  SearchCourse search=PageFactory.initElements(driver, SearchCourse.class);
	  
	  Thread.sleep(2000);
	  
	  search.SearchField(test);
	  
	  pom.sendKeysMethod(search.searchfield, instructor);
	  
	  search.ValidateSearchInput(test,instructor);
	  
	  pom.clickMethod(search.searchbtn);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
//	  js.executeScript("window.scrollBy(0,400)");
	  
      js.executeScript("window.scrollBy(0,200)");
      
      //Instructor
      pom.clickMethod(search.Instructor);
      
      js.executeScript("window.scrollBy(0,100)");
	  
      pom.clickMethod(search.subscriptionbtn2);

  }
  
  @Test(priority=3)
  public void Subscription() throws InterruptedException {
	  
	  Subscription sub=PageFactory.initElements(driver, Subscription.class);
	  
//	  pom.clickMethod(sub.Plan);

//	  pom.clickMethod(sub.duration2);
	  
	  sub.PayVerification(test);
	  pom.clickMethod(sub.pay1);
	  
	  sub.ReferralVerification(test);
	  pom.clickMethod(sub.referralpaste);
	  Actions act=new Actions(driver);
      act.sendKeys(Keys.CONTROL+"v").perform();
      
      sub.ReferralPasteVerification(test);
      
      sub.paymentVerification(test);
	  pom.clickMethod(sub.paymentMethod);
	  
	  Thread.sleep(3000);
	  
	  driver.navigate().back();
	  
	  Thread.sleep(2000);
	  pom.clickMethod(sub.HomeLogo2);
	  
  }
  
  @Test(priority=4)
  public void removecourse() throws InterruptedException {
	  RemoveCourse rob=PageFactory.initElements(driver, RemoveCourse.class);
	  
	  rob.CourseDrop(test);
	  pom.clickMethod(rob.coursedropdown);
	  
	  Thread.sleep(2000);
	  pom.clickMethod(rob.JEE);
	  
	  pom.clickMethod(rob.coursedropdown);
	  
	  rob.CourseEditbtn(test);
	  pom.clickMethod(rob.EditCourse);
	  
	  rob.CourseRemove(test);
	  pom.clickMethod(rob.Removebtn);
	  
	  rob.PopUp(test);
	  pom.clickMethod(rob.PopUpRemove);
	  
//	  Thread.sleep(1000);
//	  pom.clickMethod(rob.Donebtn);
	  driver.navigate().refresh();
	  Thread.sleep(1000);
  }
  
//  @Test(priority=5)
//  public void SignOut() {
//	  SignOut signout=PageFactory.initElements(driver, SignOut.class);
//	  
//	  signout.profileVerify(test);
//	  pom.clickMethod(signout.profile); 
//	  
//	  signout.SignoutVerify(test);
//	  pom.clickMethod(signout.sigoutbtn);
//  }
  
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
