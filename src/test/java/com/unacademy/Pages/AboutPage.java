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

public class AboutPage {
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public AboutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[3]/div/div/div/div/div/a[7]")
		public WebElement AboutExam;

	@FindBy(xpath="//a[text()=\"About Us\"]")
		public WebElement AboutPage;

	@FindBy(xpath="//a[text()=\"Careers\"]")
		public WebElement CareersPage;
	
	@FindBy(xpath="//a[text()=\"Privacy policy\"]")
		public WebElement PrivacyPolicyPage;
	
	@FindBy(xpath="//h5[text()=\"Reach out to us\"]")
		public WebElement ReactOutTitle;
	
	@FindBy(xpath="//*[@id=\"__next\"]/footer/div[1]/div[1]/div[2]/a")
		public WebElement ReactOutContact;
	
	
	
	public void Reactouttitle(ExtentTest test) {
		wait.until(ExpectedConditions.visibilityOf(ReactOutTitle));
		try {
			Assert.assertTrue(ReactOutTitle.isDisplayed(),"Title Not Found");
			test.log(Status.PASS,"Reach out to us title is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Reach Out To Us title is not Present");
		}
		
	}
	
	public void ReactoutContacts(ExtentTest test) {
		wait.until(ExpectedConditions.elementToBeClickable(ReactOutContact));
		try {
			Assert.assertTrue(ReactOutContact.isDisplayed(),"Contact Not Found");
			test.log(Status.PASS,"Contact is present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "Contact is not Present");
		}
		
	}
	
	public void AboutPages(ExtentTest test) {
		wait.until(ExpectedConditions.elementToBeClickable(AboutPage));
		try {
			Assert.assertTrue(ReactOutContact.isDisplayed(),"AboutPage Not Found");
			test.log(Status.PASS,"AboutPage is Present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "AboutPage is not Present");
		}
		
	}
	
	public void Career(ExtentTest test) {
		wait.until(ExpectedConditions.elementToBeClickable(CareersPage));
		try {
			Assert.assertTrue(CareersPage.isDisplayed(),"CareersPage Not Found");
			test.log(Status.PASS,"CareersPage is Present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "CareersPage is not Present");
		}
		
	}
	
	public void Privacypolicy(ExtentTest test) {
		wait.until(ExpectedConditions.elementToBeClickable(PrivacyPolicyPage));
		try {
			Assert.assertTrue(PrivacyPolicyPage.isDisplayed(),"PrivacyPolicyPage Not Found");
			test.log(Status.PASS,"PrivacyPolicyPage is Present");
			
		}catch(Exception e) {
			test.log(Status.FAIL, "PrivacyPolicyPage is not Present");
		}
		
	}
	
}
