package com.unacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Unacademy_POM {

	WebDriver driver;
	WebDriverWait wait;
	
	public Unacademy_POM(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickMethod(WebElement elementval) {
		wait.until(ExpectedConditions.visibilityOf(elementval));
		elementval.click();
	}

	public void sendKeysMethod(WebElement elementval,String key) {
		wait.until(ExpectedConditions.elementToBeClickable(elementval));
		elementval.sendKeys(key);
	}
}
