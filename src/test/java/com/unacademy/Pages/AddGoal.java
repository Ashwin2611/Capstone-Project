package com.unacademy.Pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AddGoal {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public AddGoal(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//button[text()=\"IIT JEE\"]")
		public WebElement addGoalbtn;
	
	@FindBy(xpath="//li[@data-id=\"goalFooter\"]")
		public WebElement addGoalbtn2;
	
	@FindBy(xpath="//*[@id=\"QUQWY\"]/div/div[1]")
		public WebElement selectExam;
	
	@FindBy(xpath="//*[@id=\"DrawerPaper\"]/div[1]")
		public WebElement Language;
	
	@FindBy(xpath="//img[@alt=\"avatar\"]")
		public WebElement giftIcon;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[2]/button[1]")
		public WebElement referralCode;
	
	@FindBy(xpath="//img[@alt=\"Company Logo\"]")
		public WebElement HomeLogo;
	
	@FindBy(xpath="//h4[text()=\"My goals\"]")
		public WebElement GoalTitle;
	
	@FindBy(xpath="//h4[text()=\"PLUS4YWPZ\"]")
	 	public WebElement referralcodePresent;
	
	
	public void GiftIconVerify(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(giftIcon));
		
		try {
			Assert.assertTrue(giftIcon.isDisplayed(), "Gift icon is not present");
			test.log(Status.PASS, "GIft icon is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Gift icon is not present");
		}
	}
	
	public void VerifyTitle(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(GoalTitle));
		try {
			Assert.assertTrue(GoalTitle.isDisplayed(),"Invalid Goal Title");
			test.log(Status.PASS, "Goal Title is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Goal Title is not Present");
		}
	}
	
	public void VerifyAddGoalbtn(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(addGoalbtn2));
		try {
			Assert.assertTrue(addGoalbtn2.isDisplayed(),"Add Course Button is not displayed");
			test.log(Status.PASS,"Add Course Button is Present");
		}catch(Exception e) {
			test.log(Status.FAIL,"Add Course Button is not Present");
		}
	}
	
	public void VerifyReferralCode(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(referralcodePresent));
		try {
			Assert.assertTrue(referralcodePresent.isDisplayed(),"Referral Code is not present");
			test.log(Status.PASS, "Referral Code is Present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Referral Code is not Present");
		}
	}
		
	

}

