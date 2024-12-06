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

public class SignOut {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public SignOut(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//picture/img")
		public WebElement profile;
	
	@FindBy(xpath="(//div[@role])[3]")
		public WebElement sigoutbtn;
	
	
	public void profileVerify(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(profile));
		try {
			Assert.assertTrue(profile.isDisplayed(),"Profile Not Found");
			test.log(Status.PASS,"Profile is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Profile is not Present");
		}
		
	}
	
	public void SignoutVerify(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(sigoutbtn));
		try {
			Assert.assertTrue(sigoutbtn.isDisplayed(),"Signout button Not Found");
			test.log(Status.PASS,"Signout button is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Signout button is not Present");
		}
		
	}
}
