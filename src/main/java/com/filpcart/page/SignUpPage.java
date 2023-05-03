package com.filpcart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;


public class SignUpPage {
	
	WebDriver driver;
	ExtentTest test;
	
	public SignUpPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@class,'2doB4z')]")
	public WebElement popupCrossButton;
	

}
