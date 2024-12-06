package com.unacademy.Pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class loginPage {
	WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[text()='Log in']")
		public WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"DrawerPaper\"]/div[2]/div[1]/h2")
		WebElement LoginTitle;

	@FindBy(xpath="//*[@id=\"DrawerPaper\"]/div[2]/div[1]/div[2]/div/input")
		WebElement contactField;
	
	@FindBy(xpath="//*[@id=\"DrawerPaper\"]/div[2]/div[1]/div[3]/button")
		public WebElement Loginbtn;
	
	@FindBy(xpath="//h6[text()=\"Continue with email\"]")
		public WebElement Continuewithemail;
	
	@FindBy(xpath="//input[@placeholder=\"Email address\"]")
		public WebElement emailField;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
		public WebElement Login1;
	
	@FindBy(xpath="//input[@placeholder=\"One time password\"]")
		public WebElement Otp;
	
	@FindBy(xpath="//p[text()=\"This OTP is not valid\"]")
		WebElement otpValidation;
	
	
	
	public void LoginTitle(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(LoginTitle));
		try {
			assertEquals(LoginTitle.getText(),"Login","Login Title not Matched");
			test.log(Status.PASS, "Login Title Matched");
		}catch(Exception e) {
			test.log(Status.FAIL,e.getMessage());
		}
		
	}
	
	public void ContactField(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(contactField));
		try {
			Assert.assertTrue(contactField.isDisplayed(),"Contact Field is not present");	
			test.log(Status.PASS,"Contact Field is Present");
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	public void Loginbtn(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(Loginbtn));
		try {
			Assert.assertTrue(Loginbtn.isDisplayed(),"Login button is not present");
			test.log(Status.PASS,"Login button is present");
		}catch(Exception e) {
			test.log(Status.FAIL,e.getMessage());
		}
	}
	
	public void EmailField(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		try {
			Assert.assertTrue(emailField.isDisplayed(), "Email field is not present");
			test.log(Status.PASS, "Email field is presemt");
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	public void ContinueWithEmailVerify(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(Continuewithemail));
		try {
			Assert.assertTrue(Continuewithemail.isDisplayed(),"Continue with eamil field not found");
			test.log(Status.PASS,"Continue with email field is present");
		}catch(Exception e) {
			test.log(Status.FAIL,e.getMessage());
		}
	}
	public void ValidateEmail(String email,ExtentTest test) {
		if(email.endsWith("@gmail.com")) {
			test.log(Status.PASS,"Email:Valid Email");
		}else {
			test.log(Status.FAIL, "Email:Invalid Email");
		}
	}
	public void ValidateOTP(String otp,ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(otpValidation));
		try {
			Assert.assertFalse(otpValidation.isDisplayed(),"this OTP is not valid");
			test.log(Status.PASS, "OTP:Valid OTP");
		}catch(Exception e) {
			test.log(Status.FAIL, "OTP:Invalid OTP");
		}
	}

	
	
		
}
