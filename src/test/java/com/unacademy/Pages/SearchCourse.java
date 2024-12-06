package com.unacademy.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SearchCourse {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public SearchCourse(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[1]/div[2]/div[1]/div/div/div/div/div/input")
		public WebElement searchfield;
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[1]/div[2]/div[1]/div/div/div/div[2]/ul/a/div")
		public WebElement searchbtn;
	
	@FindBy(xpath="//div[@orientation=\"horizontal\"]/a")
		public WebElement course;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/h4")
		public WebElement InstructorName;
	
	@FindBy(xpath="(//button[@aria-label=\"Get subscription\"])[2]")
		public WebElement subscriptbtn;
	
	@FindBy(xpath="(//img[@orientation=\"horizontal\"])[3]")
		public WebElement course2;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div/div/h4")
		public WebElement InstructorName2;
	
	@FindBy(xpath="(//button[text()=\"Get subscription\"])[2]")
		public WebElement subscriptionbtn2;
	
	@FindBy(xpath="(//img[@alt=\"new-thumbnail\"])[1]")
	public WebElement Instructor;
	
	@FindBy(xpath="//h3[text()=\"No result found\"]")
	public WebElement noresult;

	
	public void SearchField(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(searchfield));
		
		try {
			Assert.assertTrue(searchfield.isDisplayed(), "Search field is not present");
			test.log(Status.PASS, "Search Field is Present");
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	public void ValidateSearchInput(ExtentTest test,String instructor) {
		try {
			Assert.assertFalse(instructor.equals(""), "Enter Instructor Name");
			test.log(Status.PASS,"Search Field is Not Empty");
		}catch(Exception e) {
			test.log(Status.FAIL,e.getMessage());
		}
		
		if(instructor.matches("[a-zA-Z]+")==true) {
			test.log(Status.PASS, "InstructorName:Valid InstructorName");
		}else {
			test.log(Status.FAIL, "InstructorName:Invalid InstructorName");
		}
		
	}
	
	public void ValidateInstructorName(ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(InstructorName.isDisplayed()?InstructorName:InstructorName2));
		try {
			Assert.assertTrue(InstructorName.isDisplayed(),"Instructor Name is Not displayed");
			test.log(Status.PASS,"Instructor Name found");
		}catch(Exception e){
			test.log(Status.FAIL,e.getMessage());
		}
	}
	
	public void ValidateSearchInputCourse(ExtentTest test,String course) {
		try {
			Assert.assertFalse((course.equals("") || (course.matches("[a-zA-Z]+")==true)), "Enter Course Name");
			test.log(Status.PASS,"Course Name:Valid Course Name");
		}catch(Exception e) {
			test.log(Status.FAIL,"Course Name:Invalid Course Name");
		}
		
//		if(course.matches("[a-zA-Z]+")==true) {
//			test.log(Status.PASS, "Course Name:Valid Course Name");
//		}else {
//			test.log(Status.FAIL, "Course Name:Invalid Course Name");
//		}

		
	}
	
	
}
