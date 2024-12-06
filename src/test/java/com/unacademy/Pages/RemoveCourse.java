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

public class RemoveCourse {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public RemoveCourse(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[1]/div[1]/div[2]/div/button")
	public WebElement coursedropdown;
	
	@FindBy(xpath="//h6[text()=\"Edit\"]")
	public WebElement EditCourse;
	
	@FindBy(xpath="//img[@alt=\"remove\"]")
	public WebElement Removebtn;
	
	@FindBy(xpath="//div[@data-id=\"goalSection\"]/div/div/div[2]")
	public WebElement JEE;
	
	@FindBy(xpath="//button[@aria-label=\"Remove\"]")
	public WebElement PopUpRemove;
	
	@FindBy(xpath="//h6[text()=\"Done\"]")
	public WebElement Donebtn;

	public void CourseDrop(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(coursedropdown));
		
		try {
			Assert.assertTrue(coursedropdown.isDisplayed(), "Course Dropdown is not present");
			test.log(Status.PASS, "Course Dropdown is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Course Dropdown is not present");
		}
	}
	
	public void CourseEditbtn(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(EditCourse));
		
		try {
			Assert.assertTrue(EditCourse.isDisplayed(), "Edit Course button is not present");
			test.log(Status.PASS, "Edit Course button is present");
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	public void CourseRemove(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(Removebtn));
	
		try {
			Assert.assertTrue(Removebtn.isDisplayed(), "Remove Course button is not present");
			test.log(Status.PASS, "Remove Course button is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Remove Course button is not present");
		}
	}
	
	public void PopUp(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(PopUpRemove));
	
		try {
			Assert.assertTrue(PopUpRemove.isDisplayed(), "Remove Course PopUp is not present");
			test.log(Status.PASS, "Remove Course PopUp button is present");
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	
	
	

}
