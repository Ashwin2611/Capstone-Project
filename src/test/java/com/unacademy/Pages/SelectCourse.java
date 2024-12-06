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

public class SelectCourse {

	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public SelectCourse(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div[2]/div[2]/div[4]/div[1]/div[4]/a")
		public WebElement coursesection;
	
	@FindBy(xpath="(//div[@data-analytics=\"goal-courseCard\"])[1]")
		public WebElement coursemodule;
	
	@FindBy(xpath="(//button[@aria-label=\"Get subscription\"])[2]")
	public WebElement subscriptbtn;
	
	public void Course(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(coursesection));
		try {
			Assert.assertTrue(coursesection.isDisplayed(),"Course Section is not present");
			test.log(Status.PASS,"Course Section is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Course Section is not present");
		}
		
	}
	
	public void CourseModule(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(coursemodule));
		try {
			Assert.assertTrue(coursemodule.isDisplayed(),"Course Module is not present");
			test.log(Status.PASS,"Course Module is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Course Module is not present");
		}
		
	}
	
	public void Subscriptbtn(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(subscriptbtn));
		try {
			Assert.assertTrue(coursemodule.isDisplayed(),"subscription button is not present");
			test.log(Status.PASS,"subscription button is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "subscription buttonds is not present");
		}
		
	}
	
	
	
	
		
}
