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

public class Subscription {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public Subscription(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//button/span[text()=\"Select ICONIC\"]")
		public WebElement Plan;
	
	@FindBy(xpath="(//div[@gridcolumn=\"span 13\"])[3]")
		public WebElement duration;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[3]/div[4]/div/button")
		public WebElement proceedtopaybtn;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[3]/div[3]/div/button")
		public WebElement proceedtopay1;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[3]/div[3]/div/button")
		public WebElement pay1;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[3]/div/div[2]/div/div/div/input")
		public WebElement referralpaste;
	
	@FindBy(xpath="//div[@data-id=\"8\"]")
		public WebElement paymentMethod;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[3]/div[2]/div[4]/div")
		public WebElement duration2;
	
	@FindBy(xpath="//img[@alt=\"Company Logo\"]")
		public WebElement HomeLogo;
	
	@FindBy(xpath="//a[@href=\"/\"]")
		public WebElement HomeLogo2;
	
	@FindBy(xpath="//input[@data-testid=\"referralInput\"]")
		public WebElement pastedrefferalcode;
	
	
	public void PlanVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(Plan));
		try {
			Assert.assertTrue(Plan.isDisplayed(),"Plan is not visible");
			test.log(Status.PASS, "Plan is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Plan is not present");
		}
	}
	
	public void durationVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(duration));
		try {
			Assert.assertTrue(duration.isDisplayed(),"duration is not visible");
			test.log(Status.PASS, "duration is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "duration is not present");
		}
	}
	
	public void proceedtopayVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(proceedtopaybtn));
		try {
			Assert.assertTrue(proceedtopaybtn.isDisplayed(),"Proceed to pay is not visible");
			test.log(Status.PASS, "Proceed to pay is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Proceed to pay is not present");
		}
	}
	
	public void paymentVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(paymentMethod));
		try {
			Assert.assertTrue(paymentMethod.isDisplayed(),"payment Method is not visible");
			test.log(Status.PASS, "payment Method is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "payment Method is not present");
		}
	}
	
	public void PayVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(pay1));
		try {
			Assert.assertTrue(pay1.isDisplayed(),"Proceed to pay is not visible");
			test.log(Status.PASS, "Proceed to pay is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Proceed to pay is not present");
		}
	}
	
	public void ReferralVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(referralpaste));
		try {
			Assert.assertTrue(referralpaste.isDisplayed(),"Referral field is not visible");
			test.log(Status.PASS, "Referral field is present");
		}catch(Exception e) {
			test.log(Status.FAIL, "Referral field is not present");
		}
	}
	
	public void ReferralPasteVerification(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(pastedrefferalcode));

		String value=pastedrefferalcode.getAttribute("value");
		
		if(value.isEmpty()) {
			test.log(Status.FAIL, "Referral code is not Pasted");
		}else {
			test.log(Status.PASS, "Referral code is Pasted");
		}
	}
	
	
}

